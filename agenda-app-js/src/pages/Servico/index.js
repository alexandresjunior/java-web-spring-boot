import React from "react";
import "../../assets/css/meusServicos.css";

const MeusServicos = () => {
    return (
        <main className="d-flex justify-content-center align-items-center flex-column">
            <div className="main-container d-flex flex-column gap-3 align-items-center" id="agendamento-pai">
                <h4 id="titulo-agendamento" className="card-title">Meus Servicos:</h4>
                <div className="alert alert-danger d-none text-center" id="nenhum-agendamento" role="alert">
                    <h4 className="alert-heading">Você não possui serviços.</h4>
                    <hr />
                    <p>Por favor adicione algum serviço.</p>
                </div>
            </div>
            <div>
                <a href="./cadastroDeServico.html"><button id="agendar-servico" className="botao mt-5">NOVO SERVIÇO</button></a>
            </div>
        </main>
    )
}

export default MeusServicos;