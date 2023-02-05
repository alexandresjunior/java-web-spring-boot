import React from "react";
import { Link, useLocation } from "react-router-dom";
import "../../assets/css/meusServicos.css";
import { useServicos } from "../../hooks/useServicos";

const MeusServicos = () => {
    const location = useLocation();
    const [servicos, setServicos] = useServicos();

    return (
        <main className="d-flex justify-content-center align-items-center flex-column">
            <div className="main-container d-flex flex-column gap-3 align-items-center" id="agendamento-pai">
                <h4 id="titulo-agendamento" className="card-title">Meus Servicos:</h4>
                {
                    servicos.length > 0 ? (
                        servicos.map((servico, indice) => {
                            <p key={indice}>{servico.nome}</p>
                        })
                    ) : (
                        <div className="alert alert-danger d-none text-center" id="nenhum-agendamento" role="alert">
                            <h4 className="alert-heading">Você não possui serviços.</h4>
                            <hr />
                            <p>Por favor adicione algum serviço.</p>
                        </div>
                    )
                }
            </div>

            <Link to={`${location.pathname}/cadastrar-servico`}>
                <button id="agendar-servico" className="botao mt-5">NOVO SERVIÇO</button>
            </Link>
        </main>
    )
}

export default MeusServicos;