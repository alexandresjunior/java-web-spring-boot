import React from "react";
import { Link, useLocation } from "react-router-dom";
import "../assets/css/header.css";

const Header = () => {
    const location = useLocation();

    const ehAbaAtiva = (url) => {
        return location.pathname === url ? "aba-ativa" : "aba";
    }

    return (
        <header className="header-geral">
            <nav className="navbar navbar-dark navbar-expand-sm colo cor-azul text-light p-0">
                <div className="container">
                    <div className="logo"><a className="navbar-brand text-light " href="/">agendapp</a></div>
                    <button className="navbar-toggler" type="button" data-bs-toggle="collapse"
                        data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false"
                        aria-label="Toggle navigation">
                        <span className="navbar-toggler-icon"></span>
                    </button>
                    <div className="collapse navbar-collapse" id="navbarNavAltMarkup">
                        <div className="navbar-nav ms-auto">
                            <Link to="/" className={`nav-link ${ehAbaAtiva("/")}`}>Login</Link>
                            <Link to="/cadastro" className={`nav-link ${ehAbaAtiva("/cadastro")}`}>Cadastro</Link>
                        </div>
                    </div>
                </div>
            </nav>
        </header>
    )
}

export default Header;