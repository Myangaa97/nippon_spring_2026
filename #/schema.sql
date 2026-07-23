create table products (
	id serial primary key,
	name varchar(200) unique not null,
	description varchar,
	price numeric(10, 2) not null
	stock_quantity int,
	is_active boolean default true
);

insert into products (
	name, description, price, stock_quantity)
	values 
		('iphone', 'Apple brand', 1500.00, 100),
		('mouse', 'Razer brand', 100.00, 15);

select * from products;

@Entity
@Table(name = "products")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, unique = true, length = 200)
	private String name;

	@Column(columnDefinition = "TEXT")
	private String description;

	@Column(nullable = false, precision = 10, scale = 2)
	private BigDecimal price;

	@Column(name = "stock_quantity")
	private Integer stockQuantity;

	@Column(name = "is_active", nullable = false)
	private Boolean isActive = true;
}

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	Optional<Product> findByName(String name);
}


@RestController
@RequestMapping("/api/products")
public class ProductController {
	@GetMapping
	public List<Product> getAllProducts() {
		return ProductRepository.findByIsActiveTrue();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable Long id) {
		return ProductRepository.findById(id)
		.map(ResponseEntity::ok)
		.orElse(ResponseEntity.notFound().build());
	}
}