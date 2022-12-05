/*
 * "Final Reality" (c) by R8V and Johnny Godoy
 * "Final Reality" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <http://creativecommons.org/licenses/by/4.0/>.
 */
package cl.uchile.dcc.finalreality.exceptions

/**
 * This error is used if a mage cannot perform a spell.
 * It doesn't find the missspells in this project.
 *
 * @constructor Creates a new `SpellFailException` with a `description` of the
 * error.
 *
 * @author <a href="https://www.github.com/johnny-godoy">Johnny</a>
 */
class SpellFailException(description: String) :
    Exception(description)
