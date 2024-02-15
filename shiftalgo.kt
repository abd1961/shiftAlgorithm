

fun shiftChars(shiftAmount: Int, word: String): String {
    // Create an empty string for the result
    var result = ""

    // Loop through each character
    for (char in word) {
        // Get the ASCII code
        var charCode = char.toInt()

        // Check if the character is a letter
        if (charCode in 65..90 || charCode in 97..122) {
            // Check if it's an uppercase letter
            val isUpperCase = charCode in 65..90

            // Perform the shift
            charCode += shiftAmount

            // Loop through the letters to wrap around Z or z
            if (isUpperCase) {
                if (charCode > 90) {
                    charCode = 64 + (charCode - 90)
                } else if (charCode < 65) {
                    charCode = 91 - (65 - charCode)
                }
            } else {
                if (charCode > 122) {
                    charCode = 96 + (charCode - 122)
                } else if (charCode < 97) {
                    charCode = 123 - (97 - charCode)
                }
            }
        }

        // Add the encrypted character to the result string
        result += charCode.toChar()
    }

    return result
}

fun main() {
    // Example usage of the shiftChars function
    val result = shiftChars(2, "aabc")
    println(result) // Output: ccde
}
