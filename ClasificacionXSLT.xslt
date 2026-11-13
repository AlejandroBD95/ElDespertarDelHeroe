<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  <xsl:template match="/">
    <html>
      <body>
        <h1>Clasificación de heroes</h1>
        <table border="1">
          <tr>
            <th>Nombre</th>
            <th>Puntuación</th>
          </tr>
          <xsl:for-each select="clasificacion/heroe">
            <tr>
              <td>
                <xsl:value-of select="nombre"/>
              </td>
              <td>
                <xsl:value-of select="puntuacion"/>
              </td>
            </tr>
          </xsl:for-each>
        </table>
      </body>
    </html>
  </xsl:template>
</xsl:stylesheet>