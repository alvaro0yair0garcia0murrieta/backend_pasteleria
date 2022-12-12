var btnRegistrar = document.getElementById("ingresar")
btnRegistrar.addEventListener("click", function () {
    axios.post("https://backendpasteleria-production.up.railway.app/usuariosB", {
        email : document.getElementById("email").value,
        password : document.getElementById("password").value
    }).then(function(){
        
    })


})



function login(){
    window.location.href="registro.html";
}



