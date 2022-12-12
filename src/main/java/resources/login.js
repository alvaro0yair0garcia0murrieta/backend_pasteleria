var btnRegistrar = document.getElementById("ingresar")
btnRegistrar.addEventListener("click", function () {
    axios.post("http://localhost:4567/usuarioB", {
        email : document.getElementById("email").value,
        password : document.getElementById("password").value
    }).then(function(){
        
    })


})



function login(){
    window.location.href="registro.html";
}



