use ecommerceDB;

INSERT INTO products (code, name, description, img_link, quantity, price)
VALUES
('P001', 'iPhone 14', 'Apple smartphone with A15 Bionic chip', 'https://store.storeimages.cdn-apple.com/4982/as-images.apple.com/is/iphone-14', 15, 799.00),
('P002', 'MacBook Air', 'M2 chip with 256GB SSD and 8GB RAM', 'https://store.storeimages.cdn-apple.com/4982/as-images.apple.com/is/macbook-air-m2', 10, 1099.00),
('P003', 'AirPods Pro', 'Active noise cancellation and spatial audio', 'https://store.storeimages.cdn-apple.com/4982/as-images.apple.com/is/airpods-pro', 25, 249.00),
('P004', 'Apple Watch Series 8', 'Health and fitness tracking', 'https://store.storeimages.cdn-apple.com/4982/as-images.apple.com/is/apple-watch-series-8', 20, 399.00),
('P005', 'iPad 10.2"', '10.2-inch Retina display with A13 chip', 'https://store.storeimages.cdn-apple.com/4982/as-images.apple.com/is/ipad-10-2', 12, 329.00),
('P006', 'Logitech MX Master 3S', 'Ergonomic wireless mouse', 'https://resource.logitech.com/w_692,c_limit,q_auto:best,f_auto,dpr_1.0/d_transparent.gif/content/dam/logitech/en/products/mice/mx-master-3s/gallery/mx-master-3s-top-view-graphite.png', 50, 99.99),
('P007', 'Keychron K8 Keyboard', 'Wireless mechanical keyboard (Hot-swappable)', 'https://www.keychron.com/cdn/shop/products/K8_1_1400x.jpg', 40, 89.99),
('P008', 'Anker USB-C Hub', '7-in-1 hub with HDMI, SD, USB 3.0', 'https://m.media-amazon.com/images/I/61B04HGBJvL._AC_SL1500_.jpg', 60, 49.99),
('P009', 'Samsung T7 SSD', 'Portable 1TB USB 3.2 external SSD', 'https://images.samsung.com/is/image/samsung/p6pim/levant/portable-ssd-t7', 20, 119.99),
('P010', 'Logitech C920 Webcam', 'Full HD 1080p webcam with stereo audio', 'https://resource.logitech.com/w_692,c_limit,q_auto:best,f_auto,dpr_1.0/d_transparent.gif/content/dam/logitech/en/products/webcams/c920/gallery/c920-gallery-1.png', 35, 69.99);

INSERT INTO orders (customer_username) VALUES ('joe'); -- Order 1
INSERT INTO orders (customer_username) VALUES ('joe'); -- Order 2
INSERT INTO orders (customer_username) VALUES ('joe'); -- Order 3


INSERT INTO order_items (order_id, product_code, quantity) VALUES
(1, 'P001', 1),
(1, 'P003', 2),
(1, 'P007', 1);

INSERT INTO order_items (order_id, product_code, quantity) VALUES
(2, 'P002', 1),
(2, 'P006', 2),
(2, 'P008', 1),
(2, 'P009', 1);

INSERT INTO order_items (order_id, product_code, quantity) VALUES
(3, 'P004', 1),
(3, 'P005', 1),
(3, 'P010', 2),
(3, 'P003', 1),
(3, 'P001', 1);
