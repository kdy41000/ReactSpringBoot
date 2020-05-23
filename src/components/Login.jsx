import React, { Component } from 'react';
import loginAxios from '../backend/loginAxios';

class Login extends Component {

    state = {
        id: '',
        pw: ''
    }

    appChange = (e) => {
        this.setState({
            [e.target.name]: e.target.value
        });
    }

    callback = (data) => {
        if(data === true){
            alert("로그인 성공");
        }else{
            alert("로그인 실패");
        }
    }

    appClick = () => {
 
      loginAxios('/login',this.callback, this.state.id,this.state.pw);
    }

    render() {
        const { id, pw } = this.state;
        const { appChange, appClick } = this;
        return (
            <div>
                <h1>로그인</h1>
                아이디: <input type="text" name="id" placeholder="아이디 입력" value={id} onChange={appChange}/><br/>
                비밀번호: <input type="password" name="pw" placeholder="비밀번호 입력" value={pw} onChange={appChange}/><br/>
                <button onClick={appClick}>로그인</button>
        </div>
        );
    }
}

export default Login;