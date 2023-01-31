import React from "react";
import Header from "../../components/Header";
import Footer from "../../components/Footer";
import "../../assets/css/login.css";

const Login = () => {
    return (
        <>
            <Header />
            <main className="form-signin d-flex align-items-center justify-content-center flex-column">
                <form id="form-signin">
                    <div id="div-login">
                        <label htmlFor="inputLogin ">Login:</label>
                        <input type="text" className="form-control" id="inputLogin" />
                    </div>

                    <div id="div-senha">
                        <label htmlFor="inputSenha">Senha:</label>
                        <input type="password" className="form-control" id="inputSenha" />
                    </div>
                    <div className="d-none pt-2" id="login-incorreto">
                        <p className="text-danger">Login ou senha incorretos</p>
                    </div>

                    <button className="w-100 btn btn-lg btn-primary mt-3" id="btnSubmit" type="submit">Entrar</button>
                </form>
            </main>
            <Footer />
        </>
    )
}

export default Login;