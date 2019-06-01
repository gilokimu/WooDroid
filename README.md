

<img src="https://github.com/gilokimu/woocommerce-android-sdk/raw/master/app/src/main/res/mipmap-xxxhdpi/ic_launcher_round.png"/> 

# Woocommerce Android SDK
This is an woocommerce api client for android

<img src="https://github.com/gilokimu/woocommerce-android-sdk/raw/master/screens/screenshot-1553916911644.jpg" width="285"/> <img src="https://github.com/gilokimu/woocommerce-android-sdk/raw/master/screens/screenshot-1553916952806.jpg" width="285"/> <img src="https://github.com/gilokimu/woocommerce-android-sdk/raw/master/screens/screenshot-1553916959446.jpg" width="285"/> <img src="https://github.com/gilokimu/woocommerce-android-sdk/raw/master/screens/screenshot-1553916965766.jpg" width="285"/> <img src="https://github.com/gilokimu/woocommerce-android-sdk/raw/master/screens/screenshot-1553916980710.jpg" width="285"/> <img src="https://github.com/gilokimu/woocommerce-android-sdk/raw/master/screens/screenshot-1553916989454.jpg" width="285"/> <img src="https://github.com/gilokimu/woocommerce-android-sdk/raw/master/screens/screenshot-1553917011606.jpg" width="285"/>
<img src="https://github.com/gilokimu/woocommerce-android-sdk/raw/master/screens/screenshot-1554348601504.jpg" width="285"/>

Built-based on the documentation: http://woocommerce.github.io/woocommerce-rest-api-docs/#introduction

## Installation
Please note that files are still being moved around - the project should be stable before end Feb 2019

### Maven dependency:
Step 1. Add the JitPack repository to your build file

```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>
```

Step 2. Add the dependency
```xml
<dependency>
	<groupId>com.github.gilokimu</groupId>
	<artifactId>woodroid</artifactId>
	<version>0.2.0</version>
</dependency>
```

### Gradle dependency:
Step 1. Add the JitPack repository to your build file

```gradle
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```

Step 2. Add the dependency
```gradle
dependencies {
	implementation 'com.github.gilokimu:woodroid:0.2.0'
}
```

## Getting started

Generate API credentials (Consumer Key & Consumer Secret) following this instructions <http://docs.woocommerce.com/document/woocommerce-rest-api/>
.

Check out the WooCommerce API endpoints and data that can be manipulated in <https://woocommerce.github.io/woocommerce-rest-api-docs/>.

## Setup

Setup for the new WP REST API integration (WooCommerce 2.6 or later):

```kotlin
val woocommerce = Woocommerce.Builder()
	.setSiteUrl("http://example.com")
	.setApiVersion(Woocommerce.API_V2)
	.setConsumerKey("ck_XXXXX")
	.setConsumerSecret("cs_XXXX")
	.build()
```

## Usage
Getting products example

```kotlin
woocommerce.ProductRepository().products().enqueue(object : Callback<List<Product>> {
        override fun onResponse(call: Call<List<Product>>, response: Response<List<Product>>) {
            val productsResponse = response.body()
            for (product in productsResponse!!) {
                products.add(product)
            }

            adapter.notifyDataSetChanged()
        }

        override fun onFailure(call: Call<List<Product>>, t: Throwable) {

        }
    })
```

## Supported resources
The sdk currently supports : 
1. Order Notes
2. Refunds
3. Attributes
4. Attribute Terms  
5. Product Category  
6. Shipping Class  
7. Product Tags  
8. Variations  
9. Coupons
10. Customers  
11. Orders  
12. Products  
13. Reports 

### Coming soon
14. Settings 
15. Payment gateway

## API Methods
The general resource method calls are
1. Create - Pass the object to create
2. List - a list of all items
3. View single method - retries a single item
4. Delete - deletes the resource
5. Filter - provides a list that meets a criteria

### Create Method
Create an instance of the resource then pass onto a .create() function on the resource repository

```kotlin
val coupon = Coupon()
coupon.code = code
coupon.description = description
        
woocommerce.CouponRepository().create(coupon).enqueue(object : Callback<Coupon> {
    override fun onResponse(call: Call<Coupon>, response: Response<Coupon>) {
        val couponResponse = response.body()
        finish()
    }

    override fun onFailure(call: Call<Coupon>, t: Throwable) {
        
    }
})
```

### List Method
```kotlin
 woocommerce.CouponRepository().coupons().enqueue(object : Callback<List<Coupon>> {
    override fun onResponse(call: Call<List<Coupon>>, response: Response<List<Coupon>>) {
        val couponResponse = response.body()
        for (coupon in couponResponse!!) {
            coupons.add(coupon)
        }

        adapter.notifyDataSetChanged()
    }

    override fun onFailure(call: Call<List<Coupon>>, t: Throwable) {

    }
})
```

### View single item

```kotlin
val couponId = intent.getIntExtra("couponId", 0)

woocommerce.CouponRepository().coupon(couponId).enqueue(object : Callback<Coupon> {
    override fun onResponse(call: Call<Coupon>, response: Response<Coupon>) {
        val coupon = response.body()!!

        etCode.setText(coupon.code.toUpperCase())
        etDescription.setText(coupon.description)

    }

    override fun onFailure(call: Call<Coupon>, t: Throwable) {
        
    }
})

```

### Delete item
```kotlin
woocommerce.CouponRepository().delete(couponId).enqueue(object : Callback<Coupon> {
    override fun onResponse(call: Call<Coupon>, response: Response<Coupon>) {
        if (response.isSuccessful) {
            val coupon = response.body()!!
            finish()
        }else{
            Toast.makeText(this@CouponActivity, "" + response.code() + " : " + response.message(), Toast.LENGTH_SHORT).show()
        }

    }

    override fun onFailure(call: Call<Coupon>, t: Throwable) {
        stopShowingLoading()
    }
})
```

### Filter item 
```kotlin
val filter = CouponFilter()
filter.search = "FEB"

woocommerce.CouponRepository().coupons(filter).enqueue(object : Callback<List<Coupon>> {
    override fun onResponse(call: Call<List<Coupon>>, response: Response<List<Coupon>>) {
        val couponResponse = response.body()
        for (coupon in couponResponse!!) {
            coupons.add(coupon)
        }

        adapter.notifyDataSetChanged()
    }

    override fun onFailure(call: Call<List<Coupon>>, t: Throwable) {

    }
})

```
### Sample app
The sample app implements an MVVM approach which would look slightly different from the above. The methods are the same though


## Contribution
Contributions are highly welcomed, just create a PR



