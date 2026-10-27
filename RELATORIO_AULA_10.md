# Aula 10 — Integração Contínua (CI/CD) com Automação de Qualidade

## Objetivo
Automatizar build, testes, análise estática, verificação de dependências e controle de qualidade antes da entrega.

## Implementação
- GitHub Actions: `.github/workflows/ci.yml` e `.github/workflows/quality-gate.yml`.
- Jenkins: `Jenkinsfile`, com build, testes, Checkstyle, PMD, Dependency-Check e aprovação manual para homologação.
- Testes: JUnit 5 com cenários de soma, divisão válida e divisão por zero.
- Cobertura: JaCoCo com Quality Gate mínimo de 80% das instruções.
- Análise estática: Checkstyle e PMD.
- Segurança: OWASP Dependency-Check com falha do build para vulnerabilidades de CVSS igual ou superior a 7.

## Critérios de aprovação
A pipeline deve ser considerada aprovada somente quando build, testes, cobertura e verificações de qualidade/segurança forem concluídos com sucesso. O desafio integrado da aula cita cobertura superior a 85%; para adotar esse critério estrito, altere o limite JaCoCo de `0.80` para `0.85`.

## Como validar
Execute `mvn clean verify`, `mvn checkstyle:check`, `mvn pmd:check` e `mvn org.owasp:dependency-check-maven:check`. Consulte os relatórios gerados em `target/`.

## Limitações
O deploy depende de ambiente Jenkins e homologação configurados. O SonarQube depende de URL/token válidos. A verificação OWASP precisa acessar a base de vulnerabilidades. Esses serviços não são simulados como se tivessem sido executados neste pacote.
