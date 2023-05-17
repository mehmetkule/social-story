import axios from 'axios';
export const signUp =  (body) =>{
   return axios.post("/api/1/user", body)
}
