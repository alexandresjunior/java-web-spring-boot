import React from "react";
import "../../assets/css/meusAgendamentos.css";

const MeusAgendamentos = () => {
    return (
        <main className="d-flex justify-content-center align-items-center">
            <div className="main-container d-flex flex-column gap-3 align-items-center" id="agendamento-pai">
                <h4 id="titulo-agendamento" className="card-title">Meus Agendamentos:</h4>
                <div className="alert alert-danger d-none text-center" id="nenhum-agendamento" role="alert">
                    <h4 className="alert-heading">Você não possui nenhum agendamento.</h4>
                    <hr />
                    <p>Por favor adicione algum agendamento.</p>
                </div>
            </div>
        </main>
    )
}

export default MeusAgendamentos;