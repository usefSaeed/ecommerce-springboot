create schema ecommerceDB;

use ecommerceDB;

CREATE TABLE user_auth (
    username VARCHAR(255) PRIMARY KEY,
    hashed_password VARCHAR(255) NOT NULL, 
    salt VARCHAR(255) NOT NULL 
);

CREATE TABLE user_info (
    username VARCHAR(255) PRIMARY KEY, 
    email VARCHAR(255) NOT NULL,
    phone VARCHAR(255) NOT NULL,
    first_name VARCHAR(255) NOT NULL, 
    last_name VARCHAR(255) NOT NULL 
);

CREATE TABLE products (
    code VARCHAR(255) PRIMARY KEY, 
    name VARCHAR(255) NOT NULL,
    description VARCHAR(255) NOT NULL,
    img_link VARCHAR(255) NOT NULL, 
    quantity INT NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
	createdAt DATETIME DEFAULT CURRENT_TIMESTAMP,
	updatedAt DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE orders (
    id INT AUTO_INCREMENT PRIMARY KEY,
    customer_username VARCHAR(255) NOT NULL,
	FOREIGN KEY (customer_username) REFERENCES user_info(username),
    createdAt DATETIME DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE order_items (
    id INT AUTO_INCREMENT PRIMARY KEY,
	order_id INT NOT NULL,
    product_code VARCHAR(255) NOT NULL,
    quantity INT NOT NULL,
	FOREIGN KEY (product_code) REFERENCES products(code),
	FOREIGN KEY (order_id) REFERENCES orders(id) ON DELETE CASCADE
);

-- DROP TABLE order_items;
-- DROP TABLE orders;
-- DROP TABLE products;
-- DROP TABLE user_auth;
-- DROP TABLE user_ecommerce;
-- DROP TABLE user_info;


UPDATE products SET img_link = 'https://www.google.com/url?sa=i&url=https%3A%2F%2Ftechcrunch.com%2F2022%2F09%2F14%2Freview-apple-iphone-14-pro%2F&psig=AOvVaw1sFsE90MZOtTs9ANf3GkWK&ust=1752202000925000&source=images&cd=vfe&opi=89978449&ved=0CBQQjRxqFwoTCOj0y6CjsY4DFQAAAAAdAAAAABAL' WHERE code = 'P001';

UPDATE products SET img_link = 'https://store.storeimages.cdn-apple.com/4982/as-images.apple.com/is/macbook-air-midnight-select-20220606?wid=904&hei=840&fmt=jpeg&qlt=90&.v=1653084303665' WHERE code = 'P002';

UPDATE products SET img_link = 'https://store.storeimages.cdn-apple.com/4982/as-images.apple.com/is/MTJV3?wid=572&hei=572&fmt=jpeg&qlt=95&.v=1694014871985' WHERE code = 'P003';

UPDATE products SET img_link = 'https://store.storeimages.cdn-apple.com/4982/as-images.apple.com/is/MT843?wid=572&hei=572&fmt=jpeg&qlt=95&.v=1694014871985' WHERE code = 'P004';

UPDATE products SET img_link = 'https://store.storeimages.cdn-apple.com/4982/as-images.apple.com/is/ipad-10-2-2021-hero-silver-wifi-select?wid=940&hei=1112&fmt=png-alpha&.v=1631130203000' WHERE code = 'P005';

UPDATE products SET img_link = 'https://resource.logitech.com/w_692,c_limit,q_auto,f_auto,dpr_1.0/d_transparent.gif/content/dam/logitech/en/products/mice/mx-master-3s/gallery/mx-master-3s-top-view-graphite.png?v=1' WHERE code = 'P006';

UPDATE products SET img_link = 'https://www.keychron.com/cdn/shop/products/K8_wireless_mechanical_keyboard_pro_gateron_red_switch_1800x1800_1b1d5d1e-1c2a-4c2e-8b9a-9c1b2d3e4f5c_1800x1800.jpg?v=1676546329' WHERE code = 'P007';

UPDATE products SET img_link = 'https://m.media-amazon.com/images/I/61B04HH0EJL._AC_SL1500_.jpg' WHERE code = 'P008';

UPDATE products SET img_link = 'https://images.samsung.com/is/image/samsung/p6pim/br/870-qvo/feature/br-870-qvo-532064841?$650_519_PNG$' WHERE code = 'P009';

UPDATE products SET img_link = 'https://resource.logitech.com/w_692,c_limit,q_auto,f_auto,dpr_1.0/d_transparent.gif/content/dam/logitech/en/products/webcams/c920e-hd-pro-webcam/gallery/c920e-gallery-1.png?v=1' WHERE code = 'P010';

