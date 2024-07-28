/**   
 * @author Stephen M. Borja
 * @author Mariella Jeanne A. Dellosa
 * 
 * The page state.
 */

package constants;

/**
 * The page state enum.
 */
public enum PageEnum
{
    ADMIN_LOG_IN,                   /* Administrator's log-in page. */
    ADMIN_HOTEL_CREATE,             /* Hotel creation page. */
    ADMIN_HOTEL_LIST,               /* Hotel list page. */
    ADMIN_HOTEL_PROPERTIES,         /* Hotel properties page. */
    ADMIN_ROOM_PROPERTIES,          /* Room properties page. */

    CLIENT_LOG_IN,                  /* Client's log-in page. */
    CLIENT_SIGN_UP,                 /* Client's sign-up page. */
    CLIENT_RESERVATION_CREATE,      /* Reservation booking page. */
    CLIENT_RESERVATION_LIST,        /* Reservation list page. */

    PUBLIC_RESERVATION_PROPERTIES   /* Reservation properties page. */
}
