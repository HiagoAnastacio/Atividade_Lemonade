package com.example.atividade3lemonade // Define o pacote do aplicativo

import android.os.Bundle // Importa a classe Bundle para gerenciar o estado da atividade
import androidx.activity.ComponentActivity // Importa a classe base para atividades que usam Compose
import androidx.activity.compose.setContent // Importa a função para definir o conteúdo da atividade
import androidx.compose.foundation.Image // Importa a função para exibir imagens
import androidx.compose.foundation.background // Importa a função para definir o fundo de um componente
import androidx.compose.foundation.border // Importa a função para adicionar bordas a um componente
import androidx.compose.foundation.clickable // Importa a função para tornar um componente clicável
import androidx.compose.foundation.layout.* // Importa funções de layout para organizar componentes
import androidx.compose.foundation.shape.RoundedCornerShape // Importa a classe para definir formas com cantos arredondados
import androidx.compose.material3.MaterialTheme // Importa o tema Material 3
import androidx.compose.material3.Surface // Importa a superfície para aplicar o tema
import androidx.compose.material3.Text // Importa a função para exibir texto
import androidx.compose.runtime.* // Importa funções e classes para gerenciamento de estado
import androidx.compose.ui.Alignment // Importa a classe para alinhar componentes
import androidx.compose.ui.Modifier // Importa a classe para modificar componentes
import androidx.compose.ui.graphics.Color // Importa a classe para definir cores
import androidx.compose.ui.res.painterResource // Importa a função para carregar recursos de imagem
import androidx.compose.ui.res.stringResource // Importa a função para carregar recursos de string
//import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp // Importa a classe para definir dimensões em dp
import androidx.compose.ui.unit.sp // Importa a classe para definir tamanhos de fonte em sp
//import com.example.atividade3lemonade.R // Importa o arquivo de recursos do aplicativo
import com.example.atividade3lemonade.ui.theme.Atividade3LemonadeTheme // Importa o tema do aplicativo

class MainActivity : ComponentActivity() { // Define a classe MainActivity que herda de ComponentActivity
    override fun onCreate(savedInstanceState: Bundle?) { // Método chamado ao criar a atividade
        super.onCreate(savedInstanceState) // Chama o método da superclasse
        setContent { // Define o conteúdo da atividade
            Atividade3LemonadeTheme { // Aplica o tema do aplicativo
                LimonadaApp() // Chama a função composable LimonadaApp
            }
        }
    }
}

@Composable // Anotação que indica que a função é um composable
fun LimonadaApp() { // Define a função composable LimonadaApp
    var currentStep by remember { mutableIntStateOf(1) } // Cria um estado mutável para controlar o passo atual

    Surface( // Cria uma superfície para aplicar o tema
        modifier = Modifier.fillMaxSize(), // Preenche toda a área disponível
        color = MaterialTheme.colorScheme.background // Define a cor de fundo do tema
    ) {
        Box(modifier = Modifier.fillMaxSize()) { // Cria uma caixa que preenche toda a área
            Box( // Cria uma caixa para o cabeçalho
                modifier = Modifier
                    .fillMaxWidth() // Preenche toda a largura
                    .height(100.dp) // Define a altura da caixa
                    .background(color = Color(red = 249, green = 228, blue = 76, alpha = 255)) // Define a cor de fundo
                    .align(Alignment.TopCenter) // Alinha a caixa no topo ao centro
            ) {
                Text( // Exibe o texto "Limonada"
                    text = "Limonada", // Define o texto a ser exibido
                    fontSize = 24.sp, // Define o tamanho da fonte
                    color = Color.Black, // Define a cor do texto
                    modifier = Modifier.align(Alignment.Center) // Alinha o texto ao centro da caixa
                )
            }

            when (currentStep) { // Verifica o passo atual
                1 -> { // Se o passo atual for 1
                    Column( // Cria uma coluna para empilhar componentes verticalmente
                        horizontalAlignment = Alignment.CenterHorizontally, // Alinha os componentes horizontalmente ao centro
                        verticalArrangement = Arrangement.Center, // Alinha os componentes verticalmente ao centro
                        modifier = Modifier.fillMaxSize() // Preenche toda a área disponível
                    ) {
                        Image( // Exibe a imagem da árvore de limão
                            painter = painterResource(R.drawable.lemon_tree), // Carrega a imagem da árvore de limão
                            contentDescription = stringResource(R.string.lemon_tree_content_description), // Define a descrição da imagem
                            modifier = Modifier
                                .wrapContentSize() // Ajusta o tamanho da imagem ao conteúdo
                                .background(color = Color(0xFFC3ECD2), shape = RoundedCornerShape(20.dp)) // Define o fundo e a forma da imagem
                                .padding(horizontal = 20.dp) // Adiciona preenchimento horizontal
                                .border(width = 2.dp, color = Color(0xFFC3ECD2), shape = RoundedCornerShape(20.dp)) // Adiciona uma borda à imagem
                                .clickable { currentStep = 2 } // Torna a imagem clicável e muda o passo para 2
                        )
                        Spacer(modifier = Modifier.height(32.dp)) // Adiciona um espaço vertical entre os componentes
                        Text(text = stringResource(R.string.lemon_tree_content_description), fontSize = 19.sp) // Exibe a descrição da árvore de limão
                    }
                }
                2 -> { // Se o passo atual for 2
                    Column( // Cria uma coluna para empilhar componentes verticalmente
                        horizontalAlignment = Alignment.CenterHorizontally, // Alinha os componentes horizontalmente ao centro
                        verticalArrangement = Arrangement.Center, // Alinha os componentes verticalmente ao centro
                        modifier = Modifier.fillMaxSize() // Preenche toda a área disponível
                    ) {
                        var limao = (1..5).random() // Gera um número aleatório entre 1 e 4
                        Image( // Exibe a imagem de espremer limão
                            painter = painterResource(R.drawable.lemon_squeeze), // Carrega a imagem de espremer limão
                            contentDescription = stringResource(R.string.lemon_content_description), // Define a descrição da imagem
                            modifier = Modifier
                                .wrapContentSize() // Ajusta o tamanho da imagem ao conteúdo
                                .background(color = Color(0xFFC3ECD2), shape = RoundedCornerShape(20.dp)) // Define o fundo e a forma da imagem
                                .padding(horizontal = 20.dp) // Adiciona preenchimento horizontal
                                .border(width = 2.dp, color = Color(0xFFC3ECD2), shape = RoundedCornerShape(20.dp)) // Adiciona uma borda à imagem
                                .clickable { // Torna a imagem clicável
                                    when (limao) { // Verifica o valor de limao
                                        1 -> currentStep = 3 // Se for 1, muda o passo para 3
                                        else -> limao -= 1 // Caso contrário, diminui o valor de limao
                                    }
                                }
                        )
                        Spacer(modifier = Modifier.height(32.dp)) // Adiciona um espaço vertical entre os componentes
                        Text(text = stringResource(R.string.lemon_content_description), fontSize = 19.sp) // Exibe a descrição do limão
                    }
                }
                3 -> { // Se o passo atual for 3
                    Column( // Cria uma coluna para empilhar componentes verticalmente
                        horizontalAlignment = Alignment.CenterHorizontally, // Alinha os componentes horizontalmente ao centro
                        verticalArrangement = Arrangement.Center, // Alinha os componentes verticalmente ao centro
                        modifier = Modifier.fillMaxSize() // Preenche toda a área disponível
                    ) {
                        Image( // Exibe a imagem da bebida de limão
                            painter = painterResource(R.drawable.lemon_drink), // Carrega a imagem da bebida de limão
                            contentDescription = stringResource(R.string.lemonade_content_description), // Define a descrição da imagem
                            modifier = Modifier
                                .wrapContentSize() // Ajusta o tamanho da imagem ao conteúdo
                                .background(color = Color(0xFFC3ECD2), shape = RoundedCornerShape(20.dp)) // Define o fundo e a forma da imagem
                                .padding(horizontal = 20.dp) // Adiciona preenchimento horizontal
                                .border(width = 2.dp, color = Color(0xFFC3ECD2), shape = RoundedCornerShape(20.dp)) // Adiciona uma borda à imagem
                                .clickable { currentStep = 4 } // Torna a imagem clicável e muda o passo para 4
                        )
                        Spacer(modifier = Modifier.height(32.dp)) // Adiciona um espaço vertical entre os componentes
                        Text(text = stringResource(R.string.lemonade_content_description), fontSize = 19.sp) // Exibe a descrição da bebida de limão
                    }
                }
                else -> { // Se o passo atual não for 1, 2 ou 3 (ou seja, é 4)
                    Column( // Cria uma coluna para empilhar componentes verticalmente
                        horizontalAlignment = Alignment.CenterHorizontally, // Alinha os componentes horizontalmente ao centro
                        verticalArrangement = Arrangement.Center, // Alinha os componentes verticalmente ao centro
                        modifier = Modifier.fillMaxSize() // Preenche toda a área disponível
                    ) {
                        Image( // Exibe a imagem do copo vazio
                            painter = painterResource(R.drawable.lemon_restart), // Carrega a imagem do copo vazio
                            contentDescription = stringResource(R.string.empty_glass_content_description), // Define a descrição da imagem
                            modifier = Modifier
                                .wrapContentSize() // Ajusta o tamanho da imagem ao conteúdo
                                .background(color = Color(0xFFC3ECD2), shape = RoundedCornerShape(20.dp)) // Define o fundo e a forma da imagem
                                .padding(horizontal = 20.dp) // Adiciona preenchimento horizontal
                                .border(width = 2.dp, color = Color(0xFFC3ECD2), shape = RoundedCornerShape(20.dp)) // Adiciona uma borda à imagem
                                .clickable { currentStep = 1 } // Torna a imagem clicável e muda o passo de volta para 1
                        )
                        Spacer(modifier = Modifier.height(32.dp)) // Adiciona um espaço vertical entre os componentes
                        Text(text = stringResource(R.string.empty_glass_content_description), fontSize = 19.sp) // Exibe a descrição do copo vazio
                    }
                }
            }
        }
    }
}

