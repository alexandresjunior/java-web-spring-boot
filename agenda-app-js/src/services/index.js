import axios from "axios";

const api = axios.create({
    baseURL: "http://localhost:8080"
})

export const obterDados = async (url, setDados) => {
    await api.get(url).then((response) => setDados(response.data)).catch((error) => console.error(error));
}

export const criarNovoDado = async (url, dado, setDado) => {
    await api.post(url, dado).then((response) => setDado(response.data)).catch((error) => console.error(error));
}

export const atualizarDado = async (url, dado, setDado) => {
    await api.put(url, dado).then((response) => setDado(response.data)).catch((error) => console.error(error));
}

export const deletarDado = async (url) => {
    await api.delete(url).catch((error) => console.error(error));
}
