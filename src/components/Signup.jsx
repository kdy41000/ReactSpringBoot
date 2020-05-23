import React, { Component } from 'react';
import signupAxios from '../backend/signupAxios';

class Signup extends Component {

    state = {
        myid: '',
        mypw: ''
    }

    appChange = (e) => {
        this.setState({
            [e.target.name]: e.target.value
        });
    }

    callback = (data) => {
        if(data === true){
            alert("회원가입을 완료하였습니다.");
            window.location.href="http://localhost:3000/login";
        }else{
            alert("회원가입을 실패하였습니다.");
            this.setState({
                myid:'',
                mypw:''
            })
        }
    }

    appClick = () => {
        signupAxios('/signup',this.callback, this.state.myid,this.state.mypw);
    }

    render() {
        const { myid, mypw } = this.state;
        const { appChange, appClick } = this;
        return (
            <div>
                <h1>회원가입</h1>
                아이디: <input type="text" name="myid" placeholder="아이디 입력" value={myid} onChange={appChange}/><br/>
                비밀번호: <input type="password" name="mypw" placeholder="비밀번호 입력" value={mypw} onChange={appChange}/><br/>
                <button onClick={appClick}>회원가입</button>
            </div>
        );
    }
}

export default Signup;