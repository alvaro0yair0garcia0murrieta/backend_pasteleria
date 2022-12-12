
window.onload = function(){  //para acceder a todos sus elementos
    const selectElement = document.forms[0].categoria;
    const container = document.getElementById("conteiner");
    const container2 = document.getElementById("sabores");
    const sendButton = document.getElementById("send-button");
    const finish = document.getElementById("finish");
   
    finish.addEventListener("click", completarCompra);
    sendButton.addEventListener("click", validate);
    selectElement.addEventListener("change", showProduct);
    product_list= [];
   
    
    var ids = 0;
    var elementos = document.forms[0].elements;


function validate(e){
        e.preventDefault();
        //var patron /^\s+/;
        var opciones=["Fresa", "Vainilla", "Durazno","Limon", "Nuez", "3 Leches"];

        let categoria = elementos[0];
        let sabor = elementos[1].value.trim();
        var cantidad = elementos[2].value;

        if(categoria.selectedIndex == 0){
            return false;
        }
        else if(opciones.includes(sabor)){
            console.log("Opcion Invalida");
            return false;
        }
        else if(sabor == null || sabor.lenght == 0){
            return false;
        }
        else if(cantidad == 0 || isNaN(cantidad)||cantidad <=0||cantidad>99){
            return false;
        }
        else{
            addProduct();
        }
        if(product_list.lenght > 0){
            finish.style.display = "block";
        }
    } 

function showProduct(){
    if(selectElement.value == "Pastel de Cumpleaños"){
        container2.textContent = "Fresa (190.0), Vainilla (160.0), Durazno (180.0), Limon (160.0), Nuez (290.0), 3 Leches(240.0)";
    }
    else if(selectElement.value == "Pastel de Chocolate"){
        container2.textContent = "Fresa (190.0), Vainilla (160.0), Durazno (180.0), Limon (160.0), Nuez (290.0), 3 Leches(240.0)";

    }
    else if(selectElement.value == "Pastel de Zanahoria"){
        container2.textContent = "Vainilla (160.0), Nuez (290.0), 3 Leches(240.0)";

    }
}

function completarCompra(){
    var total=0;
    for(var i=0; i < product_list.lenght; i++){
        console.log(product_list[i]);
        total+= product_list[i].getTotal();
    }
    alert("Monto total a pagar: "+ total);
}

function addProduct(){
    var id = ids;
    let sabor = elementos[1].value.trim();
    var categoria = elementos[0].value;
    var tamaño = document.forms[0].size.value;

    var c1= document.getElementById("Fresa");
    var c2= document.getElementById("Durazno");
    var c3= document.getElementById("3 Leches");
    var c4= document.getElementById("Nuez");
    var c5= document.getElementById("Chispas de Colores");

    var complementos = [c1,c2,c3,c4, c5];

    var Producto = new Producto(id, categoria, sabor, elementos[2],value, tamaño, complementos);
    console.log(Producto.id);
    ids+=1;

    const element = document.createElement("div");
    element.className="card";
    element.innerHTML=`
    <p><strong>${producto.tipo} de ${producto.sabor}</strong><br>
    Cantidad: ${producto.cantidad} Precio: ${producto.precio}  Complementos: ${producto.extras} 4 c/u Total a Pagar ${producto.getTotal()}</p> 
    <input type="button" name="delete" class="button" value="Eliminar"> `;

    container.appendChild(element);

    product_list.push(producto);
    document.forms[0].reset();
    console.log(product_list);

    container.addEventListener("click",
    function(e){
       if(e.target.name === "delete"){
             deleteProduct(e.target.producto.id);
       }
    });
}

function deleteProduct(element, id){
    if(element.name==="delete"){
        element.parentElement.remove();
        if(product_list.lenght > 0){
            product_list.splice(id, 1);
            ids-=1;
        }
        console.log("Productos: "+
        product_list.lenght);
    }
}

function producto(id, tipo, sabor, cantidad, tamaño, complementos){
    this.id = id;
    this.tipo = tipo;
    this.sabor = sabor;
    this.cantidad = cantidad;
    this.tamaño = tamaño;
    this.extras = "";

    console.log("ID: "+ this.id);

    switch(sabor){
        case"Fresa":
        this.precio = 190.0;
        break;
        case"Vainilla":
        this.precio = 160.0;
        break;
        case"Durazno":
        this.precio = 180.0;
        break;
        case"Limon":
        this.precio = 160.0;
        break;
        case"Nuez":
        this.precio = 290.0;
        break;
        case"3 Leches":
        this.precio = 240.0;
        break;
    
    }

 this.subtotal = this.cantidad*this.precio;

 var envase = 0;
 if(this.tamaño == "chico"){
    envase += 0.00;
 }
 else if(this.tamaño == "mediano"){
    envase += 50.00;
 }
 else if(this.tamaño == "chico"){
    envase += 100.00;
 }

 var adicional = 0;
 for(var i=0; i<complementos.lenght; i++){
    if(complementos[i].checked == true){
        adicional += 20.00;
        this.extras+=complementos[i].value = ", ";
    }
 }
 this.getTotal = function(){
    var total = this.subtotal + envase + adicional;
    return total;
 }

 }
 }

 
