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
            list[0].Tipo ="Hotel";
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

            /*list.Add(new Hotel());
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
            list[1].ImagenDetail = "http://hoteleswilson.com/wp-content/uploads/2017/06/piscina.jpg";*/

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
