# Woocommerce Android SDK

This is an android sdk for woocommerce 

# Under construction, is not ready for use yet. :(

Built-based on the documentation: http://woocommerce.github.io/woocommerce-rest-api-docs/#introduction

## Installation

### Maven dependency:
```xml
TODO
```

### Gradle dependency:
TODO

## Getting started

Generate API credentials (Consumer Key & Consumer Secret) following this instructions <http://docs.woocommerce.com/document/woocommerce-rest-api/>
.

Check out the WooCommerce API endpoints and data that can be manipulated in <https://woocommerce.github.io/woocommerce-rest-api-docs/>.

## Setup

Setup for the new WP REST API integration (WooCommerce 2.6 or later):

```kotlin
 val woocommerce = Woocommerce.Builder()
            .setSiteUrl("http://example.com")
            .setApiVersion("2")
            .setConsumerKey("ck_XXXXX")
            .setConsumerSecret("cs_XXXX")
            .build()
```

## Usage
Getting products example

```kotlin
  woocommerce.products.enqueue(object : Callback<ArrayList<Product>> {
            override fun onResponse(call: Call<ArrayList<Product>>, response: Response<ArrayList<Product>>) {
                val products = response.body()
                for (product in products!!) {
                    tvText.append(product.title + "\n")
                }
            }

            override fun onFailure(call: Call<ArrayList<Product>>, t: Throwable) {

            }
        })
```
