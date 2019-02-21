# Woocommerce Android SDK

This is an android sdk for woocommerce 

# Under construction, is not ready for use yet. :(

![alt text](https://github.com/gilokimu/woocommerce-android-sdk/raw/master/screens/screenshot-1549248597583.jpg "Woocommerce Android app")

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
	<version>0.1.0</version>
</dependency>
```

### Gradle dependency:
Step 1. Add the JitPack repository to your build file

```xml
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
```

Step 2. Add the dependency
```xml
dependencies {
	implementation 'com.github.gilokimu:woodroid:0.1.0'
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

## API Support Checklist

Method | Create | Delete | Retrieve  | Update | Batch
--------------------- | ------------- | ------------- | ------------- | ------------- | -------------   
Coupons | N | N | N | N | N 
Customers | N | N | N | N | N
Orders | N | N | N | N | N
Order notes | N | N | N | N | N
Refunds | N | N | N | N | N
Products | N | N | N | N | N
Product variations | N | N | N | N | N
Product attributes | N | N | N | N | N
Product attribute terms | N | N | N | N | N
Product categories | N | N | N | N | N
Product shipping classes | N | N | N | N | N
Product tags | N | N | N | N | N
Product reviews | N | N | N | N | N
Reports | N | N | N | N | N
Tax rates | N | N | N | N | N
Tax classes | N | N | N | N | N
Webhooks | N | N | N | N | N
Settings | N | N | N | N | N
Setting options | N | N | N | N | N
Payment gateways | N | N | N | N | N
Shipping zones | N | N | N | N | N
Shipping zone locations | N | N | N | N | N
Shipping zone methods | N | N | N | N | N
Shipping methods | N | N | N | N | N


## TODO
See the trello board for items and progress https://trello.com/b/Muw8vcBb/woocommerce-android-sdk

##Contribution
Contributions are highly welcomed, just create a PR



