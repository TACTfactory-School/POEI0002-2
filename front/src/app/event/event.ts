import { User } from '../user/user';

export interface Event {
  nbPlace: number;
  nbPlaceRest: number;
  id: number;
  title: string;
  description: string;
  createdAt: string;
  dueAt: string;
  author: User;
  city: string;
  photo: string;
  adresse: string;
  Cp: number;

}
