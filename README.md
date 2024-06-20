# PokeDex App
## Descripción
PokeDex es una aplicación de Android construida con Jetpack Compose que utiliza la PokeApi para buscar Pokémon y mostrar información detallada sobre ellos. La app muestra el número del Pokémon, su nombre, imagen, peso, altura y sonidos.

## Características
- Búsqueda de cualquier Pokémon por nombre.
- Mostrar el número, nombre, imagen, peso, altura y sonidos del Pokémon.
- Interfaz amigable con Jetpack Compose.

## Capturas de Pantalla
Pantalla de Inicio

Pantalla de Búsqueda Vacía

Pantalla de Resultado de Búsqueda (Pikachu)

## Instalación
1. Clonar el repositorio:
   ```bash
   git clone https://github.com/Alba2809/pokeapi_consume_android
   ```
2. Abrir el proyecto en Android Studio.
3. Compilar y ejecutar la app en un emulador o dispositivo físico.

## Uso
- Abrir la app PokeDex.
- Serás recibido por la pantalla de inicio.
- En la pantalla principal de búsqueda, escribe el nombre del Pokémon que deseas buscar.
- Presiona el botón de búsqueda para mostrar la información del Pokémon.

## API
Esta app utiliza [PokeApi](https://pokeapi.co/) para obtener datos de los Pokémon.

## Dependencias
- **Retrofit - GSON**: Para las solicitudes a la API.
- **Coil**: Para cargar imágenes de forma asíncrona.
- **Navigation-Compose**: Para la navegación entre ventanas.
- **Splashscreen**: Para modificar la ventana de inicio de la app.
