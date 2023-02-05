import { useEffect, useState } from "react";
import { obterDados } from "../services";

export const useServicos = () => {
    const [servicos, setServicos] = useState([])

    useEffect(() => {
        obterDados("/servicos", setServicos);
    }, [])

    return [servicos, setServicos]
}
