import api from './index';
import { Product } from '../models/product';

export const fetchProducts = async (): Promise<any> => {
  const response = await api.get('/product');
  return response.data;
};