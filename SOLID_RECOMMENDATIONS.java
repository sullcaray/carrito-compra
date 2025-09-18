// RECOMENDACIÓN 1: Separar responsabilidades del ShoppingCartController

// Crear un servicio para gestión de carrito temporal
@Service
public class CartSessionService {

    public void addToCart(Integer productId, Integer quantity, String sessionId);
    public List<ShoppingCartDetail> getCartItems(String sessionId);
    public void removeFromCart(Integer productId, String sessionId);
    public void clearCart(String sessionId);
    public BigDecimal calculateTotal(String sessionId);
}

// RECOMENDACIÓN 2: Separar AuthService en servicios más específicos

@Service
public interface AuthenticationService {
    Authentication authenticate(LoginRequest loginRequest);
}

@Service
public interface TokenService {
    String generateToken(UserDetails userDetails);
    boolean validateToken(String token);
}

// RECOMENDACIÓN 3: Aplicar DIP correctamente en controladores

@Controller
@RequiredArgsConstructor // Inyección por constructor
public class ShoppingCartController {

    private final CartSessionService cartSessionService;
    private final ProductService productService;
    private final UserService userService;

    // Eliminar variables de estado de instancia
    // Usar servicios para gestionar estado
}

// RECOMENDACIÓN 4: Crear DTOs para transferencia de datos

public class CartItemDTO {
    private Integer productId;
    private String productName;
    private BigDecimal price;
    private Integer quantity;
    private BigDecimal subtotal;
}

public class CartSummaryDTO {
    private List<CartItemDTO> items;
    private BigDecimal total;
    private Integer totalItems;
}
