package me.gilo.woodroid;

import android.content.Context;
import me.gilo.woodroid.repo.*;
import me.gilo.woodroid.repo.order.OrderNoteRepository;
import me.gilo.woodroid.repo.order.RefundRepository;
import me.gilo.woodroid.repo.product.*;

public class Woocommerce {

    public static final ApiVersion API_V1 = ApiVersion.API_VERSION1;
    public static final ApiVersion API_V2 = ApiVersion.API_VERSION2;
    public static final ApiVersion API_V3 = ApiVersion.API_VERSION3;

    final OrderNoteRepository orderNoteRepository;
    final RefundRepository refundRepository;
    final AttributeRepository attributeRepository;
    final AttributeTermRepository attributeTermRepository;
    final CategoryRepository categoryRepository;

    final ShippingClassRepository shippingClassRepository;
    final TagRepository tagRepository;
    final VariationRepository variationRepository;
    final CouponRepository couponRepository;
    final CustomerRepository customerRepository;

    final OrderRepository orderRepository;
    final ProductRepository productRepository;

    final ReviewRepository reviewRepository;

    final ReportsRepository reportsRepository;

    final CartRepository cartRepository;


    enum ApiVersion {
        API_VERSION1{
            @Override
            public String toString() {
                return "1";
            }
        },
        API_VERSION2{
            @Override
            public String toString() {
                return "2";
            }
        },
        API_VERSION3{
            @Override
            public String toString() {
                return "3";
            }
        },
    }

    public Woocommerce(String siteUrl, ApiVersion apiVerion, String consumerKey, String consumerSecret) {
        String baseUrl = siteUrl + "/wp-json/wc/v" + apiVerion + "/";

        String cartBaseUrl = siteUrl + "/wp-json/wc/v" + 2 + "/";

        orderNoteRepository = new OrderNoteRepository(baseUrl, consumerKey, consumerSecret);
        refundRepository = new RefundRepository(baseUrl, consumerKey, consumerSecret);
        attributeRepository = new AttributeRepository(baseUrl, consumerKey, consumerSecret);
        attributeTermRepository = new AttributeTermRepository(baseUrl, consumerKey, consumerSecret);
        categoryRepository = new CategoryRepository(baseUrl, consumerKey, consumerSecret);
        shippingClassRepository = new ShippingClassRepository(baseUrl, consumerKey, consumerSecret);
        tagRepository = new TagRepository(baseUrl, consumerKey, consumerSecret);
        variationRepository = new VariationRepository(baseUrl, consumerKey, consumerSecret);
        couponRepository = new CouponRepository(baseUrl, consumerKey, consumerSecret);
        customerRepository = new CustomerRepository(baseUrl, consumerKey, consumerSecret);
        orderRepository = new OrderRepository(baseUrl, consumerKey, consumerSecret);
        productRepository = new ProductRepository(baseUrl, consumerKey, consumerSecret);

        reportsRepository = new ReportsRepository(baseUrl, consumerKey, consumerSecret);

        cartRepository = new CartRepository(cartBaseUrl, consumerKey, consumerSecret);

        reviewRepository = new ReviewRepository(baseUrl, consumerKey, consumerSecret);

    }


    public static class Builder {
        private String siteUrl;
        private ApiVersion apiVerion;
        private String consumerKey;
        private String consumerSecret;


        public Builder() {
        }

        public Builder setSiteUrl(String siteUrl) {
            this.siteUrl = siteUrl;
            return this;
        }

        public Builder setApiVersion(ApiVersion apiVerion) {
            this.apiVerion = apiVerion;
            return this;
        }

        public Builder setConsumerKey(String consumerKey) {
            this.consumerKey = consumerKey;
            return this;
        }

        public Builder setConsumerSecret(String consumerSecret) {
            this.consumerSecret = consumerSecret;
            return this;
        }


        public Woocommerce build() {
            return new Woocommerce(siteUrl, apiVerion, consumerKey, consumerSecret);
        }
    }

    public OrderNoteRepository OrderNoteRepository() {
        return orderNoteRepository;
    }

    public RefundRepository RefundRepository() {
        return refundRepository;
    }

    public AttributeRepository AttributeRepository() {
        return attributeRepository;
    }

    public AttributeTermRepository AttributeTermRepository() {
        return attributeTermRepository;
    }

    public CategoryRepository CategoryRepository() {
        return categoryRepository;
    }

    public ShippingClassRepository ShippingClassRepository() {
        return shippingClassRepository;
    }

    public TagRepository TagRepository() {
        return tagRepository;
    }

    public VariationRepository VariationRepository() {
        return variationRepository;
    }

    public CouponRepository CouponRepository() {
        return couponRepository;
    }

    public CustomerRepository CustomerRepository() {
        return customerRepository;
    }

    public OrderRepository OrderRepository() {
        return orderRepository;
    }

    public ProductRepository ProductRepository() {
        return productRepository;
    }

    public ReviewRepository ReviewRepository() {
        return reviewRepository;
    }

    public ReportsRepository ReportsRepository() {
        return reportsRepository;
    }

    public CartRepository CartRepository(Context context) {
        cartRepository.turnOnCookies(context);
        return cartRepository;
    }
}
