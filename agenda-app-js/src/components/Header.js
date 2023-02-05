import React, { useContext } from "react";
import { Link, useLocation } from "react-router-dom";
import "../assets/css/header.css";
import { GlobalContext } from "../contexts/GlobalContext";

const Header = () => {
    const location = useLocation();

    const { usuarioLogado, usuarioLogadoEhCliente, usuarioLogadoEhPrestador } = useContext(GlobalContext);

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
                            {
                                usuarioLogadoEhCliente && (
                                    <>
                                        <Link to="/agendar-servico" className={`nav-link ${ehAbaAtiva("/agendar-servico")}`}>Agendar Serviço</Link>
                                        <Link to="/meus-agendamentos" className={`nav-link ${ehAbaAtiva("/meus-agendamentos")}`}>Meus Agendamentos</Link>
                                    </>
                                )
                            }

                            {
                                usuarioLogadoEhPrestador && (
                                    <>
                                        <Link to="/meus-servicos" className={`nav-link ${ehAbaAtiva("/meus-servicos")}`}>Meus Serviços</Link>
                                        <Link to="/minha-agenda" className={`nav-link ${ehAbaAtiva("/minha-agenda")}`}>Minha Agenda</Link>
                                    </>
                                )
                            }

                            {
                                !usuarioLogado ? (
                                    <>
                                        <Link to="/" className={`nav-link ${ehAbaAtiva("/")}`}>Login</Link>
                                        <Link to="/cadastro" className={`nav-link ${ehAbaAtiva("/cadastro")}`}>Cadastro</Link>
                                    </>
                                ) : (
                                    <Link to="/" onClick={() => { }} className={`nav-link ${ehAbaAtiva("/")}`}>Logout</Link>
                                )
                            }
                        </div>
                    </div>
                </div>
            </nav>
        </header>
    )
}

export default Header;