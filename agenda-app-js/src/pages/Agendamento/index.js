import React from "react";
import { Link, useLocation } from "react-router-dom";
import "../../assets/css/meusAgendamentos.css";
import { useAgendamentos } from "../../hooks/useAgendamentos";

const MeusAgendamentos = () => {
    const location = useLocation();
    const [agendamentos, setAgendamentos] = useAgendamentos();

    return (
        <main className="d-flex justify-content-center align-items-center">
            <div className="main-container d-flex flex-column gap-3 align-items-center" id="agendamento-pai">
                <h4 id="titulo-agendamento" className="card-title">Meus Agendamentos:</h4>

                {
                    agendamentos.length ? (
                        agendamentos.map((agendamento, indice) => {
                            <p key={indice}>{agendamento.data}</p>
                        })
                    ) : (
                        <div className="alert alert-danger d-none text-center" id="nenhum-agendamento" role="alert">
                            <h4 className="alert-heading">Você não possui nenhum agendamento.</h4>
                            <hr />
                            <p>Por favor adicione algum agendamento.</p>
                        </div>
                    )
                }
            </div>

            <Link to={`${location.pathname}/agendar-servico`}>
                <button id="agendar-servico" className="botao mt-5">AGENDAR SERVIÇO</button>
            </Link>
        </main>
    )
}

export default MeusAgendamentos;