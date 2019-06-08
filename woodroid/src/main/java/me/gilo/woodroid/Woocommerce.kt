package me.gilo.woodroid

import android.content.Context
import me.gilo.woodroid.data.ApiVersion
import me.gilo.woodroid.repo.*
import me.gilo.woodroid.repo.order.OrderNoteRepository
import me.gilo.woodroid.repo.order.RefundRepository
import me.gilo.woodroid.repo.product.*

class Woocommerce(siteUrl: String, apiVerion: ApiVersion, consumerKey: String, consumerSecret: String) {
    companion object {
        val API_V1 = ApiVersion.API_VERSION1
        val API_V2 = ApiVersion.API_VERSION2
        val API_V3 = ApiVersion.API_VERSION3
    }

    private val orderNoteRepository: OrderNoteRepository
    private val refundRepository: RefundRepository
    private val attributeRepository: AttributeRepository
    private val attributeTermRepository: AttributeTermRepository
    private val categoryRepository: CategoryRepository
    private val shippingClassRepository: ShippingClassRepository
    private val tagRepository: TagRepository
    private val variationRepository: VariationRepository
    private val couponRepository: CouponRepository
    private val customerRepository: CustomerRepository
    private val orderRepository: OrderRepository
    private val productRepository: ProductRepository
    private val reviewRepository: ReviewRepository
    private val reportsRepository: ReportsRepository
    private val cartRepository: CartRepository
    private val paymentGatewayRepository: PaymentGatewayRepository
    private val settingsRepository: SettingsRepository
    private val shippingMethodRepository: ShippingMethodRepository



    init {
        val baseUrl = "$siteUrl/wp-json/wc/v$apiVerion/"
        val cartBaseUrl = "$siteUrl/wp-json/wc/v2/"

        orderNoteRepository = OrderNoteRepository(baseUrl, consumerKey, consumerSecret)
        refundRepository = RefundRepository(baseUrl, consumerKey, consumerSecret)
        attributeRepository = AttributeRepository(baseUrl, consumerKey, consumerSecret)
        attributeTermRepository = AttributeTermRepository(baseUrl, consumerKey, consumerSecret)
        categoryRepository = CategoryRepository(baseUrl, consumerKey, consumerSecret)
        shippingClassRepository = ShippingClassRepository(baseUrl, consumerKey, consumerSecret)
        tagRepository = TagRepository(baseUrl, consumerKey, consumerSecret)
        variationRepository = VariationRepository(baseUrl, consumerKey, consumerSecret)
        couponRepository = CouponRepository(baseUrl, consumerKey, consumerSecret)
        customerRepository = CustomerRepository(baseUrl, consumerKey, consumerSecret)
        orderRepository = OrderRepository(baseUrl, consumerKey, consumerSecret)
        productRepository = ProductRepository(baseUrl, consumerKey, consumerSecret)
        reportsRepository = ReportsRepository(baseUrl, consumerKey, consumerSecret)
        cartRepository = CartRepository(cartBaseUrl, consumerKey, consumerSecret)
        reviewRepository = ReviewRepository(baseUrl, consumerKey, consumerSecret)
        paymentGatewayRepository = PaymentGatewayRepository(baseUrl, consumerKey, consumerSecret)
        settingsRepository = SettingsRepository(baseUrl, consumerKey, consumerSecret)
        shippingMethodRepository = ShippingMethodRepository(baseUrl, consumerKey, consumerSecret)

    }

    fun OrderNoteRepository(): OrderNoteRepository {
        return orderNoteRepository
    }

    fun RefundRepository(): RefundRepository {
        return refundRepository
    }

    fun AttributeRepository(): AttributeRepository {
        return attributeRepository
    }

    fun AttributeTermRepository(): AttributeTermRepository {
        return attributeTermRepository
    }

    fun CategoryRepository(): CategoryRepository {
        return categoryRepository
    }

    fun ShippingClassRepository(): ShippingClassRepository {
        return shippingClassRepository
    }

    fun TagRepository(): TagRepository {
        return tagRepository
    }

    fun VariationRepository(): VariationRepository {
        return variationRepository
    }

    fun CouponRepository(): CouponRepository {
        return couponRepository
    }

    fun CustomerRepository(): CustomerRepository {
        return customerRepository
    }

    fun OrderRepository(): OrderRepository {
        return orderRepository
    }

    fun ProductRepository(): ProductRepository {
        return productRepository
    }

    fun ReviewRepository(): ReviewRepository {
        return reviewRepository
    }

    fun ReportsRepository(): ReportsRepository {
        return reportsRepository
    }

    fun PaymentGatewayRepository(): PaymentGatewayRepository {
        return paymentGatewayRepository
    }

    fun SettingsRepository(): SettingsRepository {
        return settingsRepository
    }

    fun ShippingMethodRepository(): ShippingMethodRepository {
        return shippingMethodRepository
    }

    fun CartRepository(context: Context): CartRepository {
        cartRepository.turnOnCookies(context)
        return cartRepository
    }

    class Builder {
        private lateinit var siteUrl: String
        private lateinit var apiVersion: ApiVersion
        private lateinit var consumerKey: String
        private lateinit var consumerSecret: String

        fun setSiteUrl(siteUrl: String): Builder {
            this.siteUrl = siteUrl
            return this
        }

        fun setApiVersion(apiVerion: ApiVersion): Builder {
            this.apiVersion = apiVerion
            return this
        }

        fun setConsumerKey(consumerKey: String): Builder {
            this.consumerKey = consumerKey
            return this
        }

        fun setConsumerSecret(consumerSecret: String): Builder {
            this.consumerSecret = consumerSecret
            return this
        }


        fun build(): Woocommerce {
            return Woocommerce(siteUrl, apiVersion, consumerKey, consumerSecret)
        }


    }



}
