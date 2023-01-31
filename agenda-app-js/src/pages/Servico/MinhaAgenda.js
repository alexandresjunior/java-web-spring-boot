import React from "react";
import "../../assets/css/minhaAgenda.css";

const MinhaAgenda = () => {
    return (
        <main className="d-flex justify-content-center align-items-center ">
            <div className="main-container d-flex flex-column gap-3" id="agendamento-pai">
                <h4 className="card-title text-center" id="titulo-agendamento">Minha Agenda:</h4>
                <div className="alert alert-danger d-none text-center" id="nenhum-agendamento" role="alert">
                    <h4 className="alert-heading">Você não possui nenhum agendamento.</h4>
                    <hr />
                </div>
            </div>
        </main>
    )
}

export default MinhaAgenda;