import React from "react";
import "../assets/css/footer.css";

const Footer = () => {
    return (
        <footer className="footer">
            <img
                src={require("../assets/img/treina_recife_logo.png")}
                alt="Logomarca da Treina Recife"
                className="img-footer"
            />
            <div className="texto-footer">
                <span>Curso Java Web com Spring Boot</span><br />
                <span>Agendapp &copy; Treina Recife</span>
            </div>
        </footer>
    )
}

export default Footer;