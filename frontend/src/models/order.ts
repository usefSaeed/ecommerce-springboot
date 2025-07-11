import { UserProfile } from "./auth";
import { Product } from "./product";

export interface OrderItemRequest {
  quantity: number;
  product: {
    code: string;
  };
}

export interface OrderItem {
  id: number;
  product: Product;
  quantity: number;
}

export interface Order {
  id: number;
  createdAt: string;
  items: OrderItem[];
}