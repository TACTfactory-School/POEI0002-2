import { User } from '../user/user';

export interface Event {
  nbPlace: number;
  id: number;
  title: string;
  description: string;
  dueAt: string;
  author: User;
  city: string;
}
