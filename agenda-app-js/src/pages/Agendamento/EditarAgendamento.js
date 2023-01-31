import React from "react";
import "../../assets/css/editarAgendamento.css";

const EditarAgendamento = () => {
    return (
        <main className="d-flex justify-content-center align-items-center">
            <div>
                <form action="#" className="agendar-form">
                    <div className="container formulario-box">
                        <div className="row">
                            <div className="col-12">
                                <div className="row">
                                    <div id="selecione-servico" className="col-12">
                                        <label htmlFor="Servico">Selecione o serviço:</label>
                                    </div>
                                    <div className="col-12">
                                        <select className="select-className" id="selecionar-servico" name="teste">
                                            <option value=""></option>
                                        </select>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div className="row">
                            <div id="data-form" className="col-8">
                                <label htmlFor="data">Data:</label>
                            </div>
                            <div id="hora-form" className="col-4">
                                <label htmlFor="hora">Hora:</label>
                            </div>
                        </div>
                        <div className="row">
                            <div className="col-8">
                                <input type="date" className="select-className text-center" name="teste" id="data">

                                </input>
                                <p className="text-danger d-none" id="data-invalida">Data inválida</p>
                            </div>
                            <div className="col-4">
                                <input type="time" className="select-className text-center" name="teste" id="hora">

                                </input>
                                <p className="text-danger d-none" id="hora-invalida">Hora inválida</p>
                            </div>
                        </div>
                        <div className="row">
                            <div className="col-12">
                                <button id="agendar-nome" className="botao mt-5">SALVAR</button>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </main>
    )
}

export default EditarAgendamento;