import React, { useState } from "react";
import {signUp} from "./api/apiCalls";
const SignUp = () => {
  const [pending, setPending] = useState(false);
  const [user, setUser] = useState({"userName":'', "firstName":'', "email":'', "password":''});

  const event = (e) => {
    const { name, value } = e.target;
    setUser({...user, [name]: value});
  };

  const onClickSignup = async (e) => {
    e.preventDefault();
    setPending(true);
    try{
     await signUp(user)
    } catch(error){ }
    setPending(false);
  };

  return (
    <div className="container col-4">
      <form>
        <h1 className="text-center">Sign Up</h1>
        <div className="form-group">
          <label htmlFor="userName">Username</label>
          <input className="form-control" type="text" onChange={event} id="userName" name="userName" />
        </div>
        <div className="form-group">
          <label htmlFor="firstname">First Name</label>
          <input className="form-control" type="text" onChange={event} id="firstName" name="firstName" />
        </div>
        <div className="form-group">
          <label htmlFor="email">Email</label>
          <input className="form-control" type="email" onChange={event} id="email" name="email" />
        </div>
        <div className="form-group">
          <label htmlFor="password">Password</label>
          <input className="form-control" type="password" onChange={event} id="password" name="password"/>
        </div>
        <div className="text-center "> 
        <button disabled={pending} className="btn btn-primary m-2" onClick={onClickSignup} type="submit">
        {pending && <span class="spinner-border spinner-border-sm " role="status" aria-hidden="true"></span>}
        Sign Up
        </button>
        </div>
      </form>
    </div>
  );
};

export default SignUp;
