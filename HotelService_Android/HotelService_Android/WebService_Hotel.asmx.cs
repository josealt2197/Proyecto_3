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

            using (HotelEntities dc = new HotelEntities())
            {
                var v = dc.Hotel.Where(a => a.Id == id).ToList();
                if (v != null)
                {
                    foreach (var item in v)
                    {
                        list.Add(item);
                    }
                }
                else
                {
                    throw new Exception("Error en intentar filtrar el registro");
                }

            }
            return JsonConvert.SerializeObject(list, Newtonsoft.Json.Formatting.Indented);
        }
    }
}
