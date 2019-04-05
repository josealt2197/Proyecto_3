using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Services;
using HotelService_Android;
using Newtonsoft.Json;

namespace HotelService_Android
{
    [WebService(Namespace = "http://localhost:65400/WebService_Hotel")]
    [WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]
    [System.ComponentModel.ToolboxItem(false)]
    // Para permitir que se llame a este servicio web desde un script, usando ASP.NET AJAX, quite la marca de comentario de la línea siguiente. 
    // [System.Web.Script.Services.ScriptService]
    public class WebService_Hotel : System.Web.Services.WebService
    {

        [WebMethod]
        public string SearchHotel(int id)
        {
            List<Hotel> list = new List<Hotel>();

            list.Add(new Hotel());
            list[0].Id = 1;
            list[0].NombreHos = "Hotel Marriot";
            list[0].Tipo = "Hotel";
            list[0].CantidadHuespedes = 4;
            list[0].UbicacionExacta = "700 meters west from Bridgestone/Firestone La Ribera de Belen CR-H Heredia, 40703";
            list[0].ProvinciaHos = "Heredia";
            list[0].ServiciosIncluidos = "WiFi gratis, Aire acondicionado, Parqueo gratis";
            list[0].Precio = 308;
            list[0].ImagenHos = "img/hotels/Marriot.png";
            list[0].HoraEntradaHos = "2:00 p.m";
            list[0].HoraSalidaHos = "12:00 m.d.";
            list[0].DescripcionHos = "El Costa Rica Marriott Hotel es un hotel de 4 estrellas cerca del centro de Heredia, Costa Rica. Elegido por Condé Nast como uno de los mejores hoteles de Centroamérica, ofrecemos una hermosa arquitectura estilo hacienda, elegantes habitaciones y servicio excepcional. Nuestro hotel en San José, Costa Rica ofrece fácil acceso a una variedad de actividades al aire libre como ecoturismo, cabalgatas y golf. Atracciones cercanas incluyen la plantación de café Britt, el Volcán Poás y el cráter Botos.";
            list[0].ImagenDetail = "https://q-ec.bstatic.com/images/hotel/max1024x768/184/18485289.jpg";

            list.Add(new Hotel());
            list[1].Id = 2;
            list[1].NombreHos = "Hotel Wilson";
            list[1].Tipo = "Cabinas";
            list[1].CantidadHuespedes = 2;
            list[1].UbicacionExacta = "1,5 km del cruce de Nicoya carretera hacia Santa Cruz, GU, Nicoya, Costa Rica Norte.";
            list[1].ProvinciaHos = "Guanacaste";
            list[1].ServiciosIncluidos = "WiFi gratis, Piscinas, MiniRefri, Terraza ";
            list[1].Precio = 52;
            list[1].ImagenHos = "img/hotels/Wilson.png";
            list[1].HoraEntradaHos = "2:00 p.m.";
            list[1].HoraSalidaHos = "12:00 m.d";
            list[1].DescripcionHos = "En Hoteles Wilson, nos enfocamos en brindar un servicio de calidad, humano, responsable y con alta prioridad en la felicidad de todos quienes nos acompañan en nuestras instalaciones.";
            list[1].ImagenDetail = "http://hoteleswilson.com/wp-content/uploads/2017/06/piscina.jpg";

            //list[0].=

            list.Add(new Hotel());
            list[2].Id = 3;
            list[2].NombreHos = "DoubleTree Resort by Hilton Central Pacific";
            list[2].Tipo = "Hotel";
            list[2].CantidadHuespedes = 2;
            list[2].UbicacionExacta = "Carretera A Caldera, CR 1715400, Puntarenas, Costa Rica";
            list[2].ProvinciaHos = "Puntarenas";
            list[2].ServiciosIncluidos = "WiFi gratis, Aire Acondicionado, Bar en el Hotel, Parqueo gratis";
            list[2].Precio = 143;
            list[2].ImagenHos = "img/hotels/Hilton.png";
            list[2].HoraEntradaHos = "2:00 p.m.";
            list[2].HoraSalidaHos = "12:00 m.d.";
            list[2].DescripcionHos = "El hotel Fiesta Resort & Casino de cuatro estrellas, está situado en el Roble, a escasos metros de la playa. Este hotel cuenta con 400 habitaciones, un amplio y lujoso hall, recepción 24 horas, restaurante, bar ycafetería. Además hay posibilidad de hacer deportes en el complejo como puedan ser tenis, voleyplaya, acuaerobic, ping pong, entre otros. Dentro del hotel también se puede tener la opción de ir al gimnasio, SPA, masaje y todo tipo de opciones para el relax.En la parte exterior del hotel cuenta con un jardín con piscinas para adultos y niños. Se encuentran rodeadas de tumbonas y de una zona de juego para niños. Las habitaciones tienen un aire elegante y cuentan con un mobiliario clásico. Todas las habitaciones cuentan con televisión, baño con ducha, teléfono, secador, etc. Además las habitaciones de la primera planta cuentan con amplias terrazas que ofrecen vistas de las piscinas y del jardín.";
            list[2].ImagenDetail = "https://www.hiltonhotels.com/assets/img/Hotel Images/Hilton Garden Inn/S/SJOLAGI/SJOLAGI_quicklook_thumb_ext.jpg";

            list.Add(new Hotel());
            list[3].Id = 4;
            list[3].NombreHos = "Tamarindo Diria Beach Resort";
            list[3].Tipo = "Hotel";
            list[3].CantidadHuespedes = 4;
            list[3].UbicacionExacta = "Playa Tamarindo, Costa Rica";
            list[3].ProvinciaHos = "Guanacaste";
            list[3].ServiciosIncluidos = "Wifi gratis, Restaurante, Parqueo gratis, Aire acondicionado, Gimnasio";
            list[3].Precio = 244;
            list[3].ImagenHos = "img/hotels/tamarindo.png";
            list[3].HoraEntradaHos = "2:00 p.m.";
            list[3].HoraSalidaHos = "12:00 m.d.";
            list[3].DescripcionHos = "Tamarindo Diria Beach Resort es un alojamiento de 4 estrellas situado en primera línea de la playa de Tamarindo, una de las más famosas de Costa Rica. Sus 240 habitaciones incorporan televisor de pantalla plana con canales vía satélite, caja fuerte, minibar, aire acondicionado y baño privado con amenities.Además, algunas de ellas tienen terraza particular y / o vistas al Pacífico. El resort dispone de hasta tres áreas diferentes de piscina y cuenta con gimnasio, pista de tenis, tiendas, casino y espacios de acceso exclusivo para adultos.Igualmente, proporciona servicios tales como wifi gratuito, conserjería, masajes, parking sin coste y alquiler de automóviles. Tamarindo Diria Beach Resort sirve cada mañana un desayuno buffet y alberga un total de seis restaurantes, cinco bares y una heladería. Se halla a tan solo cinco minutos en automóvil del Aeropuerto de Tamarindo y a 17 kilómetros de Playa Grande.";
            list[3].ImagenDetail = "imgio.trivago.com/gtximages/itemimages/17/68/176852_v2_y.jpeg";

            list.Add(new Hotel());
            list[4].Id = 5;
            list[4].NombreHos = "Hotel Lost Iguana Resort & Spa";
            list[4].Tipo = "Hotel";
            list[4].CantidadHuespedes = 2;
            list[4].UbicacionExacta = "1.4 KM al este de la represa Arenal, 1 - 800 - 479 -, La Fortuna, Costa Rica";
            list[4].ProvinciaHos = "Alajuela";
            list[4].ServiciosIncluidos = "WiFi gratis, Restaurante, Bar en el hotel, Parqueo gratis, Gimnasio";
            list[4].Precio = 227;
            list[4].ImagenHos = "img/hotels/lostIguana.png";
            list[4].HoraEntradaHos = "2:00 p.m.";
            list[4].HoraSalidaHos = "12:00 m.d.";
            list[4].DescripcionHos = "El Lost Iguana Resort and Spa, ubicado en la selva costarricense, es un impresionante hotel inspirado en la naturaleza ubicado en 120 hectáreas de bosque tropical preservado y hogar de la biodiversidad más fascinante. El hotel cuenta con 42 habitaciones de ladera, cada una con una impresionante vista privada del Volcán Arenal y el acceso a la puerta de la selva de todas las áreas. Hay un río que cruza la propiedad y tiene un sendero privado que le llevará profundamente en el bosque lluvioso para una caminata de 1:30 horas. Al pasear por los alrededores se pueden ver las plantas exóticas florecientes, las especies de pájaros más inusuales, las criaturas lúdicas y escuchar los suaves sonidos de la naturaleza. La noche trae sonidos de la selva, insectos relámpagos, y silencio, relajante soledad. Si eres un aventurero, o simplemente quieres relajarte y relajarte en medio del paraíso, este es el lugar perfecto para ti.";
            list[4].ImagenDetail = "https://lh5.googleusercontent.com/p/AF1QipP5NFK-u51blt_1o6_gnCfm24RLllYBrr4q6pV2=w325-h243-k-no";

            list.Add(new Hotel());
            list[5].Id = 6;
            list[5].NombreHos = "Barceló San José";
            list[5].Tipo = "Hotel";
            list[5].CantidadHuespedes = 2;
            list[5].UbicacionExacta = "El Robledal, La Uruca, 458-1150, San José, Costa Rica";
            list[5].ProvinciaHos = "San José";
            list[5].ServiciosIncluidos = "WiFi gratis, Auire acondicionado, Alberca exterior, Restaurante";
            list[5].Precio = 134;
            list[5].ImagenHos = "img/hotels/barcelo.png";
            list[5].HoraEntradaHos = "2:00 p.m.";
            list[5].HoraSalidaHos = "12:00 m.d.";
            list[5].DescripcionHos = "El Hotel Barceló San José de 5 estrellas se encuentra en el tranquilo residencial de la Uruca, a tan solo 13 Km. del Aeropuerto Internacional Juan Santamaría y a 5 Km. del centro de la capital de San José de Costa Rica. Posee buenas conexiones con las principales zonas de negocios, comerciales y áreas de entretenimiento, como el Estadio Nacional.  Este emblemático hotel urbano, de gran prestigio y tradición en el país, le ofrece un excelente servicio de singular estilo europeo. Cuenta con 254 habitaciones renovadas en el 2016 y equipadas con todas las facilidades necesarias para que disfrute de su estancia en viaje de negocios o placer.El hotel ofrece aparcamiento y gimnasio gratuito.Además, dispone de una piscina exterior y un exuberante jardín. El hotel cuenta con 3 restaurantes y un bar en los que podrá disfrutar de una amplia oferta gastronómica y una extensa carta de cócteles con música en vivo.  Destacan sus 17 salas de reuniones con diferentes capacidades, equipadas tecnológicamente para sus congresos, convenciones y eventos. También, dispone de un centro de convenciones con capacidad para hasta 1.000 personas.";
            list[5].ImagenDetail = "//imgcy.trivago.com/c_limit,d_dummy.jpeg,f_auto,h_650,q_auto,w_1000/itemimages/94/85/94855_v5.jpeg";

            list.Add(new Hotel());
            list[6].Id = 7;
            list[6].NombreHos = "Hotel Le cameleon";
            list[6].Tipo = "Hotel";
            list[6].CantidadHuespedes = 2;
            list[6].UbicacionExacta = "Cocles Beach, 155-4005, Puerto Viejo de Talamanca, Costa Rica";
            list[6].ProvinciaHos = "Limón";
            list[6].ServiciosIncluidos = "WiFi, Alberca exterior, Spa, Aire acondicionado, Bar en el Hotel";
            list[6].Precio = 187;
            list[6].ImagenHos = "img/hotels/cameleon.jpeg";
            list[6].HoraEntradaHos = "1:00 p.m.";
            list[6].HoraSalidaHos = "12:00 m.d.";
            list[6].DescripcionHos = "Le caméléon está situado en Condé y cuenta con piscina al aire libre, zona de barbacoa, jardín y terraza. Todas las habitaciones cuentan con TV de pantalla plana con canales vía satélite y baño privado. Hay conexión Wi-Fi gratuita. Las habitaciones están equipadas con aire acondicionado, lavavajillas, microondas, cafetera, ducha, secador de pelo y armario.Algunas también disponen de cocina con tostadora.Todas las habitaciones incluyen zona de estar.";
            list[6].ImagenDetail = "https://s1.hocdn.com/cache/exp/max350xmax350/hotels/3000000/2290000/2281400/2281332/6feacbea_b.jpg";

            list.Add(new Hotel());
            list[7].Id = 8;
            list[7].NombreHos = "Hotel Mar de Luz";
            list[7].Tipo = "Hotel";
            list[7].CantidadHuespedes = 4;
            list[7].UbicacionExacta = "A 200 m del centro de Jacó Beach, 61101 , Jacó, Costa Rica";
            list[7].ProvinciaHos = "Puntarenas";
            list[7].ServiciosIncluidos = "WiFi gratis, Alberca exterior, Parqueo gratis, Aire Acondicionado";
            list[7].Precio = 75;
            list[7].ImagenHos = "img/hotels/mardeluz.png";
            list[7].HoraEntradaHos = "1:00 p.m.";
            list[7].HoraSalidaHos = "12:00 m.d.";
            list[7].DescripcionHos = "Hotel Mar de Luz en Jaco está diseñado para las familias y parejas, a fin de proporcionar un ambiente pacífico y ecológicamente equilibrado para disfrutar de una estancia saludable y libre de contaminación. La infraestructura de la propiedad se construyó de manera que se mantenga la mayor armonía con la naturaleza, y se utilizaron los recursos naturales para reflejar un ambiente subtropical. La principal fuente de energía es la luz del sol, que se convierte en electricidad por paneles solares, instalados en los techos. El hotel ofrece servicios de alta calidad(Wifi y desayunos gratis) a un costo razonable y por lo tanto permite a los huéspedes disfrutar de unas vacaciones de ensueño a un precio interesante. Ven a disfrutar de unas excelentes vacaciones en el Hotel Mar de Luz.";
            list[7].ImagenDetail = "https://thumbnails.trvl-media.com/YWQ1E1ELtx-LcXBcVP5W2NiiD7E=/702x468/smart/filters:quality(60)/images.trvl-media.com/hotels/17000000/16010000/16006200/16006186/86c1b740_z.jpg";

            list.Add(new Hotel());
            list[8].Id = 9;
            list[8].NombreHos = "Hyatt Place San Jose Pinares";
            list[8].Tipo = "Hotel";
            list[8].CantidadHuespedes = 1;
            list[8].UbicacionExacta = "Plaza Momentum Pinares, 11803, Curridabat, Costa Rica";
            list[8].ProvinciaHos = "San José";
            list[8].ServiciosIncluidos = "WiFi gratis, Alberca exterior, Parqueo gratis, Gimnasio, Pet Friendly";
            list[8].Precio = 198;
            list[8].ImagenHos = "img/hotels/hyatt.png";
            list[8].HoraEntradaHos = "2:00 p.m.";
            list[8].HoraSalidaHos = "12:00 m.d.";
            list[8].DescripcionHos = "Este encantador hotel tiene una ubicación privilegiada en San José. El hotel tiene fácil acceso a los principales puntos de interés que ofrece la ciudad y está a 300 metros del centro comercial Momentum. Los huéspedes estarán a una distancia en coche de 30 minutos del centro de la ciudad, donde se puede ir de compras, a lugares de entretenimiento y encantadores restaurantes. Este encantador hotel recibe a los huéspedes con estilo y encanto, fusionando tradición y elementos modernos. Las habitaciones están decoradas con buen gusto, ofreciendo un ambiente relajante en el que trabajar y descansar en la comodidad. El hotel ofrece una amplia gama de ejemplares instalaciones que atienden a las necesidades de cada tipo de viajero.";
            list[8].ImagenDetail = "https://assets.hyatt.com/content/dam/hyatt/hyattdam/images/2016/06/22/1543/Park-Hyatt-Maldives-P008-Pool-Area.jpg/Park-Hyatt-Maldives-P008-Pool-Area.4x3.adapt.640.480.jpg";

            list.Add(new Hotel());
            list[9].Id = 10;
            list[9].NombreHos = "Hotel Quelitales";
            list[9].Tipo = "Hotel";
            list[9].CantidadHuespedes = 1;
            list[9].UbicacionExacta = "Peñas Blancas, 3 Kilómetros Este de Plaza de Deporte - Cachí, 30204, Cartago, Costa Rica";
            list[9].ProvinciaHos = "Cartago";
            list[9].ServiciosIncluidos = "WiFi gratis, Restaurante, Bar en el hotel, Parqueo gratis";
            list[9].Precio = 88;
            list[9].ImagenHos = "img/hotels/quelitales.png";
            list[9].HoraEntradaHos = "12:00 p.m.";
            list[9].HoraSalidaHos = "12:00 m.d.";
            list[9].DescripcionHos = "Hotel Quelitales, el mejor hotel en Cartago, verdadero hotel de montaña boutique, es paraíso para los birdwachers. Son muy cuidadosos en los detalles para asegurar que su estancia sea lo mejor que puede ser. Es por eso que han ganado premios por su hospitalidad durante los últimos años consecutivos.";
            list[9].ImagenDetail = "https://thumbnails.trvl-media.com/OZ";
            //list[0].=



            //using (HotelEntities dc = new HotelEntities())
            //{
            //    var v = dc.Hotel.Where(a => a.Id == id).ToList();
            //    if (v != null)
            //    {
            //        foreach (var item in v)
            //        {
            //            list.Add(item);
            //        }
            //    }
            //    else
            //    {
            //        throw new Exception("Error en intentar filtrar el registro");
            //    }

            //}
            return JsonConvert.SerializeObject(list, Newtonsoft.Json.Formatting.Indented);
        }
    }
}
