# KotlinPaperMCPluginBoilerPlate

A simple and efficient boilerplate for creating PaperMC plugins in Kotlin with Java 21.

## 📋 Prerequisites

- **Java 21** (JDK)
- **Maven 3.6+**
- **PaperMC Server 1.21.7**
- **Kotlin 1.9.24**
- **IDE** (IntelliJ IDEA recommended) please don't use this dinosaur called Eclipse, it is not supported by Kotlin and PaperMC, use IntelliJ IDEA Community instead.

## 🚀 Quick Start

### 1. Clone or download the project

```bash
git clone <your-repo>
cd KotlinPaperMCPluginBoilerPlate
```

### 2. Compile the plugin

```bash
mvn clean package
```

### 3. Installation

1. Copy the generated JAR file from `target/KotlinPaperMCPluginBoilerPlate-1.0.0.jar`
2. Place it in the `plugins/` folder of your PaperMC server
3. Restart the server

## 📁 Project Structure

```
KotlinPaperMCPluginBoilerPlate/
├── src/
│   └── Main.kt                    # Main plugin class
├── plugin.yml                     # Plugin metadata
├── pom.xml                        # Maven configuration
└── README.md                      # This file
```

## 🔧 Configuration

### plugin.yml

```yaml
name: KotlinPaperMCPluginBoilerPlate
main: me.loyfael.plugin.Main
version: 1.0.0
author: Loyfael
api-version: 1.21
```

### Customization

1. **Change plugin name**: Modify `name` in `plugin.yml` and `artifactId` in `pom.xml`
2. **Change package**: Replace `me.loyfael.plugin` with your own package
3. **Update author**: Change `author` in `plugin.yml` and `groupId` in `pom.xml`

## 🛠️ Development

### Useful Maven commands

```bash
# Compile the project
mvn compile

# Clean and compile
mvn clean compile

# Create the final JAR
mvn clean package

# Install to local repository
mvn install
```

### Basic plugin structure

```kotlin
class Main : JavaPlugin() {
    override fun onEnable() {
        // Plugin initialization code
        logger.info("Plugin enabled!")
    }

    override fun onDisable() {
        // Plugin cleanup code
        logger.info("Plugin disabled!")
    }
}
```

## 📚 Included Features

- ✅ Maven configuration for Kotlin + PaperMC
- ✅ Java 21 compatibility
- ✅ Shade plugin for packaging
- ✅ Basic plugin structure
- ✅ Enable/disable logging

## 🔍 Dependencies

### Runtime
- **PaperMC API 1.21.7** (provided)
- **Kotlin Standard Library 1.9.24**

### Build
- **Kotlin Maven Plugin**
- **Maven Compiler Plugin**
- **Maven Shade Plugin**

## 📖 Useful Resources

- [PaperMC Documentation](https://docs.papermc.io/)
- [PaperMC API Javadoc](https://papermc.io/javadocs/)
- [Kotlin Documentation](https://kotlinlang.org/docs/)
- [Maven Guide](https://maven.apache.org/guides/)

## 🚨 Important Notes

- The server must use **Java 21** to run this plugin
- The `Main` class may appear as "unused" in your IDE, this is normal as it's loaded dynamically by PaperMC
- Make sure `api-version` in `plugin.yml` matches your Minecraft version

## 🤝 Contributing

1. Fork the project
2. Create a branch for your feature
3. Commit your changes
4. Push to the branch
5. Open a Pull Request

## 📄 License

This project is a free-to-use boilerplate for your own plugins.

---

*This boilerplate saves you time by automatically configuring the development environment for your PaperMC plugins in Kotlin!*
