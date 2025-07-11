export interface UserRegisterRequest {
  username: string;
  password: string;
  firstName: string;
  lastName: string;
  email: string;
  phone: string;
}

export interface UserLoginRequest {
  username: string;
  password: string;
}

export interface UserProfile {
  username: string;
  email: string;
  phone: string;
  firstName: string;
  lastName: string;
}

export interface AuthResponse {
  token: string;
  user: UserProfile;
}