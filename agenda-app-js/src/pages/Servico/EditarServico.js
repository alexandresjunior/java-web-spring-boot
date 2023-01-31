import React from "react";
import "../../assets/css/editarServico.css";

const EditarServico = () => {
    return (
        <main className="d-flex justify-content-center align-items-center">
            <div>
                <form action="#">
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
                                <div className="row">
                                    <div id="nome-form" className="col-12 pb-2">
                                        <label htmlFor="nome">Nome:</label>
                                    </div>
                                    <div className="col-12 pb-3">
                                        <input className="select-className" type="text" name="nome" id="nome"
                                            placeholder="Digite o novo nome do serviço" />
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div className="row">
                            <div id="descricao-form" className="col-8 pb-2">
                                <label htmlFor="descricao">Editar Serviço:</label>
                            </div>
                        </div>
                        <div className="row">
                            <div className="col-12">
                                <textarea className="text-area-className" name="descricao" id="descricao" cols="42" rows="30"
                                    placeholder="Uma breve descrição do serviço..."></textarea>
                            </div>
                        </div>
                        <div className="row">
                            <div className="col-12">
                                <button id="cadastro-servico" className="botao mt-3">EDITAR</button>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </main>
    )
}

export default EditarServico;