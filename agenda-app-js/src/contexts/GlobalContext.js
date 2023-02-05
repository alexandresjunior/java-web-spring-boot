import React, { createContext, useState } from "react";

export const GlobalContext = createContext({});

export const GlobalProvider = ({ children }) => {
    const [usuarioLogado, setUsuarioLogado] = useState(false);
    const [usuarioLogadoEhCliente, setUsuarioLogadoEhCliente] = useState(false);
    const [usuarioLogadoEhPrestador, setUsuarioLogadoEhPrestador] = useState(false);

    return (
        <GlobalContext.Provider value={{ usuarioLogado, usuarioLogadoEhCliente, usuarioLogadoEhPrestador }}>
            {children}
        </GlobalContext.Provider>
    )
}