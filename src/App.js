import React, { useState, useEffect } from 'react';
import { Route, Link } from 'react-router-dom';
import './App.css';
import Home from './components/Home';
import Login from './components/Login';
import Signup from './components/Signup';
import Board from './components/Board';

const App = () => {

  return (
    <div className="App">
      <header style={{padding:'30px',backgroundColor:'#f7eeee'}}>
        <Link to="/home" style={{color:'black'}}>Home</Link>
        <Link to="/login" style={{color:'black',marginLeft:'10px'}}>로그인</Link>
        <Link to="/signup" style={{color:'black',marginLeft:'10px'}}>회원가입</Link>
      </header>
        <Route exact path="/home" component={Home} />
        <Route path="/login" component={Login} />
        <Route path="/signup" component={Signup} />
        <Route path="/board" component={Board} />
    </div>
  );
};

export default App;