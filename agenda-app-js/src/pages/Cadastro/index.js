import React from "react";
import "../../assets/css/cadastro.css";

const Cadastro = () => {
    return (
        <main className="form-signin">
            <form id="form-signin">
                <div id="div-nome">
                    <label htmlFor="inputNome">Nome:</label>
                    <input type="text" className="form-control" id="inputNome" />
                </div>

                <div id="div-email">
                    <label htmlFor="inputEmail">E-mail:</label>
                    <input type="text" className="form-control" id="inputEmail" />

                </div>

                <div id="div-senha">
                    <label htmlFor="inputSenha">Senha:</label>
                    <input type="password" className="form-control" id="inputSenha" />
                </div>

                <div id="div-senha">
                    <label htmlFor="inputConfirmarSenha">Confirmar Senha:</label>
                    <input type="password" className="form-control" id="inputConfirmarSenha" />
                </div>

                <div id="div-tipo-usuario">
                    <label htmlFor="tipoUsuario">Tipo do Usuario:</label>
                    <select className="form-control" id="tipoUsuario">
                        <option value="1">Cliente</option>
                        <option value="2">Prestador</option>
                    </select>
                </div>

                <button className="w-100 btn btn-lg btn-primary mt-5" id="btnSubmit" type="submit">Cadastrar</button>
            </form>
        </main>
    )
}

export default Cadastro;