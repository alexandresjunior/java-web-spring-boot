import { useEffect, useState } from "react";
import { obterDados } from "../services";

export const useAgendamentos = () => {
    const [agendamentos, setAgendamentos] = useState([])

    useEffect(() => {
        obterDados("/agendamentos", setAgendamentos);
    }, [])

    return [agendamentos, setAgendamentos]
}