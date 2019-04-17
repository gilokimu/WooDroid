package me.gilo.woodroid;

import android.content.Context;
import android.util.Log;
import me.gilo.woodroid.data.ApiVersion;
import me.gilo.woodroid.models.PaymentGateway;
import me.gilo.woodroid.repo.*;
import me.gilo.woodroid.repo.order.OrderNoteRepository;
import me.gilo.woodroid.repo.order.RefundRepository;
import me.gilo.woodroid.repo.product.*;
import org.json.JSONException;
import org.json.JSONObject;

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
    final PaymentGatewayRepository paymentGatewayRepository;
    final SettingsRepository settingsRepository;
    final ShippingMethodRepository shippingMethodRepository;

    public static Builder Builder(){
        return new Builder();
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
        paymentGatewayRepository = new PaymentGatewayRepository(baseUrl, consumerKey, consumerSecret);
        settingsRepository = new SettingsRepository(baseUrl, consumerKey, consumerSecret);
        shippingMethodRepository = new ShippingMethodRepository(baseUrl, consumerKey, consumerSecret);

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

    public PaymentGatewayRepository PaymentGatewayRepository() {
        return paymentGatewayRepository;
    }

    public SettingsRepository SettingsRepository() {
        return settingsRepository;
    }

    public ShippingMethodRepository ShippingMethodRepository() {
        return shippingMethodRepository;
    }

    public CartRepository CartRepository(Context context) {
        cartRepository.turnOnCookies(context);
        return cartRepository;
    }
}
