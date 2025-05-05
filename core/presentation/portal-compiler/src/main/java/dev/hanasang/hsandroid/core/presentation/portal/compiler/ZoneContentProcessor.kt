package dev.hanasang.hsandroid.core.presentation.portal.compiler

import com.google.devtools.ksp.processing.CodeGenerator
import com.google.devtools.ksp.processing.Dependencies
import com.google.devtools.ksp.processing.KSPLogger
import com.google.devtools.ksp.processing.Resolver
import com.google.devtools.ksp.processing.SymbolProcessor
import com.google.devtools.ksp.symbol.KSAnnotated
import com.google.devtools.ksp.symbol.KSFunctionDeclaration
import java.io.OutputStreamWriter

class ZoneContentProcessor(
    private val codeGenerator: CodeGenerator,
    private val logger: KSPLogger,
) : SymbolProcessor {
    override fun process(resolver: Resolver): List<KSAnnotated> {
        val symbols = resolver
            .getSymbolsWithAnnotation("dev.hanasang.hsandroid.core.presentation.portal.ZoneContent")
            .filterIsInstance<KSFunctionDeclaration>()

        if (!symbols.iterator().hasNext()) return emptyList()

        val file = codeGenerator.createNewFile(
            Dependencies(true),
            "dev.hanasang.hsandroid.generated",
            "GeneratedZoneContentRegistrar",
        )

        OutputStreamWriter(file, Charsets.UTF_8).use { writer ->
            writer.write("package dev.hanasang.hsandroid.generated\n\n")
            writer.write("import dev.hanasang.hsandroid.core.presentation.portal.*\n")
            writer.write("import androidx.compose.runtime.Composable\n\n")
            writer.write("object GeneratedZoneContentRegistrar {\n")
            writer.write("    fun registerAllTo(registry: ZoneContentRegistry) {\n")

            for (symbol in symbols) {
                val annotation = symbol.annotations.first {
                    it.shortName.asString() == "ZoneContent"
                }

                val zoneName = annotation.arguments.first().value.toString()
                val functionName = symbol.simpleName.asString()

                writer.write("        registry.register($zoneName) { $functionName() }\n")
            }

            writer.write("    }\n")
            writer.write("}\n")
        }

        return emptyList()
    }
}
