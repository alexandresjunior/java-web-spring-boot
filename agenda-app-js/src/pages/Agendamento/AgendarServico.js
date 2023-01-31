import React from "react";
import "../../assets/css/agendarServico.css";

const AgendarServico = () => {
    return (
        <main className="d-flex justify-content-center align-items-center">
            <div>
                <form action="#" id="agendar-form">
                    <div className="container formulario-box">
                        <div className="row">
                            <div className="col-12">
                                <div className="row">
                                    <div id="selecione-servico" className="col-12">
                                        <label htmlFor="Servico">Selecione o serviço:</label>
                                    </div>
                                    <div className="col-12">
                                        <select className="select-className" name="selecionar-servico" id="selecionar-servico">
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
                                <input type="date" id="data" name="data" className="select-className text-center" />
                                <p className="text-danger d-none" id="data-invalida">Data inválida</p>

                            </div>
                            <div className="col-4">
                                <input type="time" className="select-className text-center " name="hora" id="hora" />
                                <p className="text-danger d-none" id="hora-invalida">Hora inválida</p>

                            </div>
                        </div>
                        <div className="row">
                            <div className="col-12">
                                <button id="agendar-nome" className="botao mt-5">AGENDAR</button>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </main>
    )
}

export default AgendarServico;