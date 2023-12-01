
create database bd_sistema_ventas;
use bd_sistema_ventas;

-- creacion de tablas
create table clientes(
	idCliente int primary key auto_increment,
    ci int,
    nombres varchar(30),
    apellidos varchar(30),
    telefono varchar(30)
);

create table sucursales(
	idSucursal int primary key auto_increment,
    nombreSucursal varchar(30),
    telefono varchar(20)
);

create table proveedores(
	idProveedor int primary key auto_increment,
    nombres varchar(30),
    direccion varchar(30),
    telefono varchar(30)
);



create table categorias(
	idCat int primary key auto_increment,
    nombre varchar(30)
);

create table marcas(
	idMarca int primary key auto_increment,
    nombre varchar(30)
);


create table productos(
	idProducto int primary key auto_increment,
    nombre varchar(30),
    precio double,
    stock int,
    estado varchar(20),
    idCat int,
    idMarca int,
    foreign key (idCat) references categorias(idCat),
    foreign key (idMarca) references marcas(idMarca)
);


create table pedidos(
	idPedido int primary key auto_increment,
    idProducto int,
    idProveedor int,
    cantidad int,
    monto double,
    foreign key (idProducto) references productos(idProducto),
    foreign key(idProveedor) references proveedores(idProveedor)
);

create table empleados(
	idEmpleado int primary key auto_increment,
    ci int,
    nombres varchar(30),
    apellidos varchar(30),
    telefono varchar(30),
    direccion varchar(50),
    idSucursal int,
    user varchar(30),
    password varchar(30),
	foreign key(idSucursal) references sucursales(idSucursal)
);


create table ventas(
	idVenta int primary key auto_increment,
    idCliente int,
    idEmpleado int,
    factura varchar(30),
    fecha datetime,
    monto double,
    foreign key(idCliente) references clientes(idCliente),
    foreign key(idEmpleado) references empleados(idEmpleado)
);

create table detalle_ventas(
	idDet int primary key auto_increment,
    idVenta int,
    idProducto int,
    cantidad int,
    precio double,
    foreign key (idVenta) references ventas(idVenta),
    foreign key (idProducto) references productos(idProducto)
);


-- Insertar datos en la tabla clientes
INSERT INTO clientes (ci, nombres, apellidos, telefono) VALUES
(123456, 'Juan', 'Perez', '555-1234'),
(789012, 'María', 'Gómez', '555-5678'),
(345678, 'Carlos', 'López', '555-9012'),
(901234, 'Laura', 'Martínez', '555-3456'),
(567890, 'Pedro', 'Sánchez', '555-7890');

-- Insertar datos en la tabla proveedores
INSERT INTO proveedores (nombres, direccion, telefono) VALUES
('Proveedor A', 'Dirección A', '555-1111'),
('Proveedor B', 'Dirección B', '555-2222'),
('Proveedor C', 'Dirección C', '555-3333'),
('Proveedor D', 'Dirección D', '555-4444'),
('Proveedor E', 'Dirección E', '555-5555');

-- Insertar datos en la tabla de categorías
INSERT INTO categorias (nombre) VALUES
('Laptops'),
('Accesorios'),
('Impresoras');

-- Insertar datos en la tabla de marcas
INSERT INTO marcas (nombre) VALUES
('HP'),
('Dell'),
('Logitech'),
('Canon');

-- Insertar datos en la tabla de productos
INSERT INTO productos (nombre, precio, stock, estado, idCat, idMarca) VALUES
('Laptop HP EliteBook', 1200.00, 10, 'Disponible', 1, 1),
('Teclado Logitech K380', 30.00, 50, 'Disponible', 2, 3),
('Impresora Canon PIXMA', 150.00, 15, 'Disponible', 3, 4),
('Mouse Dell', 20.00, 30, 'Disponible', 2, 2),
('Laptop Dell Inspiron', 900.00, 8, 'Agotado', 1, 2),
('Altavoces Logitech Z623', 120.00, 20, 'Disponible', 2, 3);

-- Insertar datos en la tabla pedidos
INSERT INTO pedidos (idProducto, idProveedor, cantidad, monto) VALUES
(1, 1, 10, 999.90),
(2, 2, 5, 749.95),
(3, 3, 8, 1599.92),
(4, 4, 12, 959.88),
(5, 5, 7, 909.93);

-- Insertar datos en la tabla sucursales
INSERT INTO sucursales (direccion, telefono) VALUES
('Sucursal A', '555-9999'),
('Sucursal B', '555-8888'),
('Sucursal C', '555-7777'),
('Sucursal D', '555-6666'),
('Sucursal E', '555-5555');

-- Insertar datos en la tabla empleados
INSERT INTO empleados (ci, nombres, apellidos, telefono, direccion, user, password,idSucursal) VALUES
(987654, 'Ana', 'Rodríguez', '555-2345', 'Calle A #123', 'ana123', 'contrasena123',1),
(543210, 'David', 'Hernández', '555-6789', 'Calle B #456', 'david456', 'contrasena456',2),
(654321, 'Elena', 'Torres', '555-7890', 'Calle C #789', 'elena789', 'contrasena789',3),
(123987, 'Gabriel', 'Ramírez', '555-8901', 'Calle D #012', 'gabriel012', 'contrasena012',4),
(789456, 'Isabel', 'Díaz', '555-2345', 'Calle E #345', 'isabel345', 'contrasena345',5);




-- creacion de vistas
create or replace view vs_venta
as
select v.idVenta,c.nombres as cliente,e.nombres as empleado,s.nombreSucursal,v.factura,v.fecha,v.monto
from ventas v natural join empleados e join sucursales s using (idSucursal) join clientes c using (idCliente);

create or replace view vs_empleado
as
select e.idEmpleado,e.ci,s.nombreSucursal,e.nombres,e.apellidos,e.telefono,e.direccion,e.user,e.password
from empleados e join sucursales s using(idSucursal);

-- consultas varias
select d.idVenta, p.nombre,d.cantidad,d.precio
from detalle_ventas d natural join productos p
where d.idVenta = 1;

select * from empleados inner join sucursales where user = ? and password = ?;
select * from vs_empleado;
select * from empleados join sucursales using(idSucursal);