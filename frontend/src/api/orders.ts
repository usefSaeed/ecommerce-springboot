import api from './index';
import { OrderItemRequest } from '../models/order';

export const fetchUserOrders = async (): Promise<any> => {
  const response = await api.get('/order');
  return response.data;
};

export const placeOrder = async (items: OrderItemRequest[]): Promise<any> => {
  const response = await api.post('/order', items);
  return response.data;
};