# Android Security Practice 🚀

Este proyecto, fue realizado utilizando la arquitectura MVVM Y tratando de basarse gran parte del codigo y el orden de los paquetes con clean Architecture, esto con el fin de tener mejor modularidad del codigo, separando la logica del negocio con la presentacion,

la estructura de carpetas y su funcionalidad se divide de la siguiente estructura :

- Api: En esta se almacenan la instancia del objeto Retrofit, la cual se encargara de manejar el consumo de la Api creada con aws, asimismo la interface encargada del acceso a las endpoints
- Model: en esta se crearon los modelos los cuales contienen los atributos que se requieren consumir de la api rest
- Presentation: En este paquete se encuentran alojados los ViewModel los cuales se encargaran del manejo del estado de los elementos en la UI (por ejemplo sobrevivir a rotaciones de pantallas) por el momento los viewModel no han sido implementados, por que no se tiene creado al 100% el backend
- Repository: aqui se crean los repositorios encargados de la abstraccion del acceso a los datos
- UI: en este paquete se alojan los fragments, adapters o elementos relacionados con la UI
- Utils: en este paquete se almacena todo tipo de utileria, por ejemplo constantes, colores, extensiones etc

# Notas
En los fragments no se ha llamado los view models ni utilizado en cuestion debido a que aun no se tiene acceso al backend, en los fragments se realizo las debidas validaciones de datos, aunque estas validaciones son meramente basicas porque apenas solo se valida si el texto no es vacio  y para tomar mas medidas de seguridad es necesario implementar mejores validaciones. solo faltaria cambiar las url, llamar al view model y la aplicacion estaria funcional.
